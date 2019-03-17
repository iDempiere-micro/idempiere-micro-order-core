package org.compiere.order;

import org.compiere.model.I_C_Order;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_C_OrderTax;
import org.compiere.model.I_C_Tax;
import org.compiere.model.I_C_TaxProvider;
import org.compiere.model.I_M_RMA;
import org.compiere.model.I_M_RMALine;
import org.compiere.model.I_M_RMATax;
import org.compiere.tax.ITaxProvider;
import org.compiere.tax.MTax;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.util.ArrayList;

import static software.hsharp.core.util.DBKt.executeUpdate;
import static software.hsharp.core.util.DBKt.executeUpdateEx;

/**
 * Standard tax provider
 *
 * @author Elaine
 * @contributor Murilo H. Torquato <muriloht@devcoffee.com.br>
 */
public class StandardTaxProvider implements ITaxProvider {

    /**
     * Logger
     */
    protected transient CLogger log = CLogger.getCLogger(getClass());

    public boolean calculateOrderTaxTotal(I_C_TaxProvider provider, I_C_Order order) {
        //	Lines
        BigDecimal totalLines = Env.ZERO;
        ArrayList<Integer> taxList = new ArrayList<Integer>();
        I_C_OrderLine[] lines = order.getLines();
        for (int i = 0; i < lines.length; i++) {
            I_C_OrderLine line = lines[i];
            totalLines = totalLines.add(line.getLineNetAmt());
            Integer taxID = line.getTaxId();
            if (!taxList.contains(taxID)) {
                MTax tax = new MTax(order.getCtx(), taxID);
                if (tax.getTaxProviderId() != 0) continue;
                MOrderTax oTax =
                        MOrderTax.get(line, order.getPrecision(), false); // 	current Tax
                oTax.setIsTaxIncluded(order.isTaxIncluded());
                if (!oTax.calculateTaxFromLines()) return false;
                if (!oTax.save()) return false;
                taxList.add(taxID);
            }
        }

        //	Taxes
        BigDecimal grandTotal = totalLines;
        I_C_OrderTax[] taxes = order.getTaxes(true);
        for (int i = 0; i < taxes.length; i++) {
            I_C_OrderTax oTax = taxes[i];
            if (oTax.getTaxProviderId() != 0) {
                if (!order.isTaxIncluded()) grandTotal = grandTotal.add(oTax.getTaxAmt());
                continue;
            }
            I_C_Tax tax = oTax.getTax();
            if (tax.isSummary()) {
                I_C_Tax[] cTaxes = tax.getChildTaxes(false);
                for (int j = 0; j < cTaxes.length; j++) {
                    I_C_Tax cTax = cTaxes[j];
                    BigDecimal taxAmt = cTax.calculateTax(oTax.getTaxBaseAmt(), false, order.getPrecision());
                    //
                    MOrderTax newOTax = new MOrderTax(order.getCtx(), 0);
                    newOTax.setClientOrg(order);
                    newOTax.setOrderId(order.getOrderId());
                    newOTax.setTaxId(cTax.getTaxId());
                    newOTax.setPrecision(order.getPrecision());
                    newOTax.setIsTaxIncluded(order.isTaxIncluded());
                    newOTax.setTaxBaseAmt(oTax.getTaxBaseAmt());
                    newOTax.setTaxAmt(taxAmt);
                    if (!newOTax.save()) return false;
                    //
                    if (!order.isTaxIncluded()) grandTotal = grandTotal.add(taxAmt);
                }
                if (!oTax.delete(true)) return false;
                if (!oTax.save()) return false;
            } else {
                if (!order.isTaxIncluded()) grandTotal = grandTotal.add(oTax.getTaxAmt());
            }
        }
        //
        order.setTotalLines(totalLines);
        order.setGrandTotal(grandTotal);
        return true;
    }

    public boolean updateOrderTax(I_C_TaxProvider provider, I_C_OrderLine line) {
        MTax mtax = new MTax(line.getCtx(), line.getTaxId());
        if (mtax.getTaxProviderId() == 0) return line.updateOrderTax(false);
        return true;
    }

    public boolean recalculateTax(I_C_TaxProvider provider, I_C_OrderLine line, boolean newRecord) {
        if (!newRecord
                && line.isValueChanged(MOrderLine.COLUMNNAME_C_Tax_ID)
                && !line.getParent().isProcessed()) {
            MTax mtax = new MTax(line.getCtx(), line.getTaxId());
            if (mtax.getTaxProviderId() == 0) {
                //	Recalculate Tax for old Tax
                if (!line.updateOrderTax(true)) return false;
            }
        }
        return line.updateHeaderTax();
    }

    public boolean updateHeaderTax(I_C_TaxProvider provider, I_C_OrderLine line) {
        //		Update Order Header
        String sql =
                "UPDATE C_Order i"
                        + " SET TotalLines="
                        + "(SELECT COALESCE(SUM(LineNetAmt),0) FROM C_OrderLine il WHERE i.C_Order_ID=il.C_Order_ID) "
                        + "WHERE C_Order_ID="
                        + line.getOrderId();
        int no = executeUpdate(sql);
        if (no != 1) log.warning("(1) #" + no);

        if (line.isTaxIncluded())
            sql =
                    "UPDATE C_Order i "
                            + " SET GrandTotal=TotalLines "
                            + "WHERE C_Order_ID="
                            + line.getOrderId();
        else
            sql =
                    "UPDATE C_Order i "
                            + " SET GrandTotal=TotalLines+"
                            + "(SELECT COALESCE(SUM(TaxAmt),0) FROM C_OrderTax it WHERE i.C_Order_ID=it.C_Order_ID) "
                            + "WHERE C_Order_ID="
                            + line.getOrderId();
        no = executeUpdate(sql);
        if (no != 1) log.warning("(2) #" + no);

        line.clearParent();
        return no == 1;
    }

    public boolean calculateRMATaxTotal(I_C_TaxProvider provider, I_M_RMA rma) {
        //	Lines
        BigDecimal totalLines = Env.ZERO;
        ArrayList<Integer> taxList = new ArrayList<Integer>();
        I_M_RMALine[] lines = rma.getLines(false);
        for (int i = 0; i < lines.length; i++) {
            I_M_RMALine line = lines[i];
            totalLines = totalLines.add(line.getLineNetAmt());
            Integer taxID = new Integer(line.getTaxId());
            if (!taxList.contains(taxID)) {
                MTax tax = new MTax(rma.getCtx(), taxID);
                if (tax.getTaxProviderId() != 0) continue;
                MRMATax oTax =
                        MRMATax.get(line, rma.getPrecision(), false); // 	current Tax
                oTax.setIsTaxIncluded(rma.isTaxIncluded());
                if (!oTax.calculateTaxFromLines()) return false;
                if (!oTax.save()) return false;
                taxList.add(taxID);
            }
        }

        //	Taxes
        BigDecimal grandTotal = totalLines;
        I_M_RMATax[] taxes = rma.getTaxes(true);
        for (int i = 0; i < taxes.length; i++) {
            I_M_RMATax oTax = taxes[i];
            if (oTax.getTaxProviderId() != 0) {
                if (!rma.isTaxIncluded()) grandTotal = grandTotal.add(oTax.getTaxAmt());
                continue;
            }
            I_C_Tax tax = oTax.getTax();
            if (tax.isSummary()) {
                I_C_Tax[] cTaxes = tax.getChildTaxes(false);
                for (int j = 0; j < cTaxes.length; j++) {
                    I_C_Tax cTax = cTaxes[j];
                    BigDecimal taxAmt = cTax.calculateTax(oTax.getTaxBaseAmt(), false, rma.getPrecision());
                    //
                    MRMATax newOTax = new MRMATax(rma.getCtx(), 0);
                    newOTax.setClientOrg(rma);
                    newOTax.setRMAId(rma.getRMAId());
                    newOTax.setTaxId(cTax.getTaxId());
                    newOTax.setPrecision(rma.getPrecision());
                    newOTax.setIsTaxIncluded(rma.isTaxIncluded());
                    newOTax.setTaxBaseAmt(oTax.getTaxBaseAmt());
                    newOTax.setTaxAmt(taxAmt);
                    if (!newOTax.save()) return false;
                    //
                    if (!rma.isTaxIncluded()) grandTotal = grandTotal.add(taxAmt);
                }
                if (!oTax.delete(true)) return false;
                if (!oTax.save()) return false;
            } else {
                if (!rma.isTaxIncluded()) grandTotal = grandTotal.add(oTax.getTaxAmt());
            }
        }
        //
        rma.setAmt(grandTotal);
        return true;
    }

    public boolean updateRMATax(I_C_TaxProvider provider, I_M_RMALine line) {
        MTax mtax = new MTax(line.getCtx(), line.getTaxId());
        if (mtax.getTaxProviderId() == 0) return line.updateOrderTax(false);
        return true;
    }

    public boolean recalculateTax(I_C_TaxProvider provider, I_M_RMALine line, boolean newRecord) {
        if (!newRecord
                && line.isValueChanged(MRMALine.COLUMNNAME_C_Tax_ID)
                && !line.getParent().isProcessed()) {
            MTax mtax = new MTax(line.getCtx(), line.getTaxId());
            if (mtax.getTaxProviderId() == 0) {
                //	Recalculate Tax for old Tax
                if (!line.updateOrderTax(true)) return false;
            }
        }

        return line.updateHeaderAmt();
    }

    public boolean updateHeaderTax(I_C_TaxProvider provider, I_M_RMALine line) {
        //	Update RMA Header
        String sql =
                "UPDATE M_RMA "
                        + " SET Amt="
                        + "(SELECT COALESCE(SUM(LineNetAmt),0) FROM M_RMALine WHERE M_RMA.M_RMA_ID=M_RMALine.M_RMA_ID) "
                        + "WHERE M_RMA_ID=?";
        int no = executeUpdateEx(sql, new Object[]{line.getRMAId()});
        if (no != 1) log.warning("(1) #" + no);

        line.clearParent();

        return no == 1;
    }

}
