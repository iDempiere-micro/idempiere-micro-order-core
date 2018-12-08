package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_AttributeSetInstance;
import org.compiere.model.I_M_InOutLine;
import org.compiere.model.I_M_Locator;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_InOutLine
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_InOutLine extends PO implements I_M_InOutLine, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_InOutLine(Properties ctx, int M_InOutLine_ID, String trxName) {
    super(ctx, M_InOutLine_ID, trxName);
    /**
     * if (M_InOutLine_ID == 0) { setC_UOM_ID (0); // @#C_UOM_ID@ setIsDescription (false); // N
     * setIsInvoiced (false); setLine (0); // @SQL=SELECT NVL(MAX(Line),0)+10 AS DefaultValue FROM
     * M_InOutLine WHERE M_InOut_ID=@M_InOut_ID@ setM_AttributeSetInstance_ID (0); setM_InOut_ID
     * (0); setM_InOutLine_ID (0); setMovementQty (Env.ZERO); // 1 setProcessed (false);
     * setQtyEntered (Env.ZERO); // 1 }
     */
  }

  /** Load Constructor */
  public X_M_InOutLine(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 1 - Org
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_M_InOutLine[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Trx Organization.
   *
   * @return Performing or initiating organization
   */
  public int getAD_OrgTrx_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_AD_OrgTrx_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Trx Organization.
   *
   * @param AD_OrgTrx_ID Performing or initiating organization
   */
  public void setAD_OrgTrx_ID(int AD_OrgTrx_ID) {
    if (AD_OrgTrx_ID < 1) set_Value(COLUMNNAME_AD_OrgTrx_ID, null);
    else set_Value(COLUMNNAME_AD_OrgTrx_ID, Integer.valueOf(AD_OrgTrx_ID));
  }

  public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException {
    return (org.compiere.model.I_C_Activity)
        MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
            .getPO(getC_Activity_ID(), get_TrxName());
  }

  /**
   * Get Activity.
   *
   * @return Business Activity
   */
  public int getC_Activity_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Activity_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Activity.
   *
   * @param C_Activity_ID Business Activity
   */
  public void setC_Activity_ID(int C_Activity_ID) {
    if (C_Activity_ID < 1) set_Value(COLUMNNAME_C_Activity_ID, null);
    else set_Value(COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
  }

  public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException {
    return (org.compiere.model.I_C_Campaign)
        MTable.get(getCtx(), org.compiere.model.I_C_Campaign.Table_Name)
            .getPO(getC_Campaign_ID(), get_TrxName());
  }

  /**
   * Get Campaign.
   *
   * @return Marketing Campaign
   */
  public int getC_Campaign_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Campaign_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Campaign.
   *
   * @param C_Campaign_ID Marketing Campaign
   */
  public void setC_Campaign_ID(int C_Campaign_ID) {
    if (C_Campaign_ID < 1) set_Value(COLUMNNAME_C_Campaign_ID, null);
    else set_Value(COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
  }

  public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException {
    return (org.compiere.model.I_C_Charge)
        MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
            .getPO(getC_Charge_ID(), get_TrxName());
  }

  /**
   * Get Charge.
   *
   * @return Additional document charges
   */
  public int getC_Charge_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Charge_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Charge.
   *
   * @param C_Charge_ID Additional document charges
   */
  public void setC_Charge_ID(int C_Charge_ID) {
    if (C_Charge_ID < 1) set_Value(COLUMNNAME_C_Charge_ID, null);
    else set_Value(COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
  }

  /**
   * Get Confirmed Quantity.
   *
   * @return Confirmation of a received quantity
   */
  public BigDecimal getConfirmedQty() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ConfirmedQty);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Confirmed Quantity.
   *
   * @param ConfirmedQty Confirmation of a received quantity
   */
  public void setConfirmedQty(BigDecimal ConfirmedQty) {
    set_Value(COLUMNNAME_ConfirmedQty, ConfirmedQty);
  }

  public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException {
    return (org.compiere.model.I_C_OrderLine)
        MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
            .getPO(getC_OrderLine_ID(), get_TrxName());
  }

  /**
   * Get Sales Order Line.
   *
   * @return Sales Order Line
   */
  public int getC_OrderLine_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_OrderLine_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Sales Order Line.
   *
   * @param C_OrderLine_ID Sales Order Line
   */
  public void setC_OrderLine_ID(int C_OrderLine_ID) {
    if (C_OrderLine_ID < 1) set_ValueNoCheck(COLUMNNAME_C_OrderLine_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
  }

  public org.compiere.model.I_C_Project getC_Project() throws RuntimeException {
    return (org.compiere.model.I_C_Project)
        MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
            .getPO(getC_Project_ID(), get_TrxName());
  }

  /**
   * Get Project.
   *
   * @return Financial Project
   */
  public int getC_Project_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Project_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Project.
   *
   * @param C_Project_ID Financial Project
   */
  public void setC_Project_ID(int C_Project_ID) {
    if (C_Project_ID < 1) set_Value(COLUMNNAME_C_Project_ID, null);
    else set_Value(COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
  }

  public org.compiere.model.I_C_ProjectPhase getC_ProjectPhase() throws RuntimeException {
    return (org.compiere.model.I_C_ProjectPhase)
        MTable.get(getCtx(), org.compiere.model.I_C_ProjectPhase.Table_Name)
            .getPO(getC_ProjectPhase_ID(), get_TrxName());
  }

  /**
   * Get Project Phase.
   *
   * @return Phase of a Project
   */
  public int getC_ProjectPhase_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_ProjectPhase_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Project Phase.
   *
   * @param C_ProjectPhase_ID Phase of a Project
   */
  public void setC_ProjectPhase_ID(int C_ProjectPhase_ID) {
    if (C_ProjectPhase_ID < 1) set_Value(COLUMNNAME_C_ProjectPhase_ID, null);
    else set_Value(COLUMNNAME_C_ProjectPhase_ID, Integer.valueOf(C_ProjectPhase_ID));
  }

  public org.compiere.model.I_C_ProjectTask getC_ProjectTask() throws RuntimeException {
    return (org.compiere.model.I_C_ProjectTask)
        MTable.get(getCtx(), org.compiere.model.I_C_ProjectTask.Table_Name)
            .getPO(getC_ProjectTask_ID(), get_TrxName());
  }

  /**
   * Get Project Task.
   *
   * @return Actual Project Task in a Phase
   */
  public int getC_ProjectTask_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_ProjectTask_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Project Task.
   *
   * @param C_ProjectTask_ID Actual Project Task in a Phase
   */
  public void setC_ProjectTask_ID(int C_ProjectTask_ID) {
    if (C_ProjectTask_ID < 1) set_Value(COLUMNNAME_C_ProjectTask_ID, null);
    else set_Value(COLUMNNAME_C_ProjectTask_ID, Integer.valueOf(C_ProjectTask_ID));
  }

  public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException {
    return (org.compiere.model.I_C_UOM)
        MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
            .getPO(getC_UOM_ID(), get_TrxName());
  }

  /**
   * Get UOM.
   *
   * @return Unit of Measure
   */
  public int getC_UOM_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_UOM_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set UOM.
   *
   * @param C_UOM_ID Unit of Measure
   */
  public void setC_UOM_ID(int C_UOM_ID) {
    if (C_UOM_ID < 1) set_ValueNoCheck(COLUMNNAME_C_UOM_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
  }

  /**
   * Set Description Only.
   *
   * @param IsDescription if true, the line is just description and no transaction
   */
  public void setIsDescription(boolean IsDescription) {
    set_Value(COLUMNNAME_IsDescription, Boolean.valueOf(IsDescription));
  }

  /**
   * Get Description Only.
   *
   * @return if true, the line is just description and no transaction
   */
  public boolean isDescription() {
    Object oo = get_Value(COLUMNNAME_IsDescription);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Description.
   *
   * @param Description Optional short description of the record
   */
  public void setDescription(String Description) {
    set_Value(COLUMNNAME_Description, Description);
  }

  /**
   * Set Invoiced.
   *
   * @param IsInvoiced Is this invoiced?
   */
  public void setIsInvoiced(boolean IsInvoiced) {
    set_Value(COLUMNNAME_IsInvoiced, Boolean.valueOf(IsInvoiced));
  }

  /**
   * Get Invoiced.
   *
   * @return Is this invoiced?
   */
  public boolean isInvoiced() {
    Object oo = get_Value(COLUMNNAME_IsInvoiced);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Get Line No.
   *
   * @return Unique line for this document
   */
  public int getLine() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Line);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Line No.
   *
   * @param Line Unique line for this document
   */
  public void setLine(int Line) {
    set_Value(COLUMNNAME_Line, Integer.valueOf(Line));
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), String.valueOf(getLine()));
  }

  public I_M_AttributeSetInstance getMAttributeSetInstance() throws RuntimeException {
    return (I_M_AttributeSetInstance)
        MTable.get(getCtx(), I_M_AttributeSetInstance.Table_Name)
            .getPO(getMAttributeSetInstance_ID(), get_TrxName());
  }

  /**
   * Set Attribute Set Instance.
   *
   * @param M_AttributeSetInstance_ID Product Attribute Set Instance
   */
  public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
    if (M_AttributeSetInstance_ID < 0) set_Value(COLUMNNAME_M_AttributeSetInstance_ID, null);
    else
      set_Value(COLUMNNAME_M_AttributeSetInstance_ID, Integer.valueOf(M_AttributeSetInstance_ID));
  }

  /**
   * Get Attribute Set Instance.
   *
   * @return Product Attribute Set Instance
   */
  public int getMAttributeSetInstance_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeSetInstance_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_M_InOut getM_InOut() throws RuntimeException {
    return (org.compiere.model.I_M_InOut)
        MTable.get(getCtx(), org.compiere.model.I_M_InOut.Table_Name)
            .getPO(getM_InOut_ID(), get_TrxName());
  }

  /**
   * Get Shipment/Receipt.
   *
   * @return Material Shipment Document
   */
  public int getM_InOut_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_InOut_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipment/Receipt.
   *
   * @param M_InOut_ID Material Shipment Document
   */
  public void setM_InOut_ID(int M_InOut_ID) {
    if (M_InOut_ID < 1) set_ValueNoCheck(COLUMNNAME_M_InOut_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_InOut_ID, Integer.valueOf(M_InOut_ID));
  }

  /**
   * Get Shipment/Receipt Line.
   *
   * @return Line on Shipment or Receipt document
   */
  public int getM_InOutLine_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_InOutLine_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipment/Receipt Line.
   *
   * @param M_InOutLine_ID Line on Shipment or Receipt document
   */
  public void setM_InOutLine_ID(int M_InOutLine_ID) {
    if (M_InOutLine_ID < 1) set_ValueNoCheck(COLUMNNAME_M_InOutLine_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_InOutLine_ID, Integer.valueOf(M_InOutLine_ID));
  }

  /**
   * Get M_InOutLine_UU.
   *
   * @return M_InOutLine_UU
   */
  public String getM_InOutLine_UU() {
    return (String) get_Value(COLUMNNAME_M_InOutLine_UU);
  }

  /**
   * Set M_InOutLine_UU.
   *
   * @param M_InOutLine_UU M_InOutLine_UU
   */
  public void setM_InOutLine_UU(String M_InOutLine_UU) {
    set_Value(COLUMNNAME_M_InOutLine_UU, M_InOutLine_UU);
  }

  public I_M_Locator getM_Locator() throws RuntimeException {
    return (I_M_Locator)
        MTable.get(getCtx(), I_M_Locator.Table_Name).getPO(getM_Locator_ID(), get_TrxName());
  }

  /**
   * Get Locator.
   *
   * @return Warehouse Locator
   */
  public int getM_Locator_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Locator_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Locator.
   *
   * @param M_Locator_ID Warehouse Locator
   */
  public void setM_Locator_ID(int M_Locator_ID) {
    if (M_Locator_ID < 1) set_Value(COLUMNNAME_M_Locator_ID, null);
    else set_Value(COLUMNNAME_M_Locator_ID, Integer.valueOf(M_Locator_ID));
  }

  /**
   * Get Movement Quantity.
   *
   * @return Quantity of a product moved.
   */
  public BigDecimal getMovementQty() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_MovementQty);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Movement Quantity.
   *
   * @param MovementQty Quantity of a product moved.
   */
  public void setMovementQty(BigDecimal MovementQty) {
    set_Value(COLUMNNAME_MovementQty, MovementQty);
  }

  public org.compiere.model.I_M_Product getM_Product() throws RuntimeException {
    return (org.compiere.model.I_M_Product)
        MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
            .getPO(getM_Product_ID(), get_TrxName());
  }

  /**
   * Get Product.
   *
   * @return Product, Service, Item
   */
  public int getM_Product_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Product.
   *
   * @param M_Product_ID Product, Service, Item
   */
  public void setM_Product_ID(int M_Product_ID) {
    if (M_Product_ID < 1) set_Value(COLUMNNAME_M_Product_ID, null);
    else set_Value(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
  }

  public org.compiere.model.I_M_RMALine getM_RMALine() throws RuntimeException {
    return (org.compiere.model.I_M_RMALine)
        MTable.get(getCtx(), org.compiere.model.I_M_RMALine.Table_Name)
            .getPO(getM_RMALine_ID(), get_TrxName());
  }

  /**
   * Get RMA Line.
   *
   * @return Return Material Authorization Line
   */
  public int getM_RMALine_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_RMALine_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set RMA Line.
   *
   * @param M_RMALine_ID Return Material Authorization Line
   */
  public void setM_RMALine_ID(int M_RMALine_ID) {
    if (M_RMALine_ID < 1) set_Value(COLUMNNAME_M_RMALine_ID, null);
    else set_Value(COLUMNNAME_M_RMALine_ID, Integer.valueOf(M_RMALine_ID));
  }

  /**
   * Get Picked Quantity.
   *
   * @return Picked Quantity
   */
  public BigDecimal getPickedQty() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PickedQty);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Picked Quantity.
   *
   * @param PickedQty Picked Quantity
   */
  public void setPickedQty(BigDecimal PickedQty) {
    set_Value(COLUMNNAME_PickedQty, PickedQty);
  }

  /**
   * Get Processed.
   *
   * @return The document has been processed
   */
  public boolean isProcessed() {
    Object oo = get_Value(COLUMNNAME_Processed);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Processed.
   *
   * @param Processed The document has been processed
   */
  public void setProcessed(boolean Processed) {
    set_Value(COLUMNNAME_Processed, Boolean.valueOf(Processed));
  }

  /**
   * Get Quantity.
   *
   * @return The Quantity Entered is based on the selected UoM
   */
  public BigDecimal getQtyEntered() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_QtyEntered);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Quantity.
   *
   * @param QtyEntered The Quantity Entered is based on the selected UoM
   */
  public void setQtyEntered(BigDecimal QtyEntered) {
    set_Value(COLUMNNAME_QtyEntered, QtyEntered);
  }

  /**
   * Get Over Receipt.
   *
   * @return Over Receipt Quantity
   */
  public BigDecimal getQtyOverReceipt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_QtyOverReceipt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Over Receipt.
   *
   * @param QtyOverReceipt Over Receipt Quantity
   */
  public void setQtyOverReceipt(BigDecimal QtyOverReceipt) {
    set_Value(COLUMNNAME_QtyOverReceipt, QtyOverReceipt);
  }

  /**
   * Get Referenced Shipment Line.
   *
   * @return Referenced Shipment Line
   */
  public int getRef_InOutLine_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Ref_InOutLine_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Referenced Shipment Line.
   *
   * @param Ref_InOutLine_ID Referenced Shipment Line
   */
  public void setRef_InOutLine_ID(int Ref_InOutLine_ID) {
    if (Ref_InOutLine_ID < 1) set_Value(COLUMNNAME_Ref_InOutLine_ID, null);
    else set_Value(COLUMNNAME_Ref_InOutLine_ID, Integer.valueOf(Ref_InOutLine_ID));
  }

  public org.compiere.model.I_M_InOutLine getReversalLine() throws RuntimeException {
    return (org.compiere.model.I_M_InOutLine)
        MTable.get(getCtx(), org.compiere.model.I_M_InOutLine.Table_Name)
            .getPO(getReversalLine_ID(), get_TrxName());
  }

  /**
   * Get Reversal Line.
   *
   * @return Use to keep the reversal line ID for reversing costing purpose
   */
  public int getReversalLine_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ReversalLine_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Reversal Line.
   *
   * @param ReversalLine_ID Use to keep the reversal line ID for reversing costing purpose
   */
  public void setReversalLine_ID(int ReversalLine_ID) {
    if (ReversalLine_ID < 1) set_Value(COLUMNNAME_ReversalLine_ID, null);
    else set_Value(COLUMNNAME_ReversalLine_ID, Integer.valueOf(ReversalLine_ID));
  }

  /**
   * Get Scrapped Quantity.
   *
   * @return The Quantity scrapped due to QA issues
   */
  public BigDecimal getScrappedQty() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ScrappedQty);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Scrapped Quantity.
   *
   * @param ScrappedQty The Quantity scrapped due to QA issues
   */
  public void setScrappedQty(BigDecimal ScrappedQty) {
    set_Value(COLUMNNAME_ScrappedQty, ScrappedQty);
  }

  /**
   * Get Target Quantity.
   *
   * @return Target Movement Quantity
   */
  public BigDecimal getTargetQty() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_TargetQty);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Target Quantity.
   *
   * @param TargetQty Target Movement Quantity
   */
  public void setTargetQty(BigDecimal TargetQty) {
    set_Value(COLUMNNAME_TargetQty, TargetQty);
  }

  public org.compiere.model.I_C_ElementValue getUser1() throws RuntimeException {
    return (org.compiere.model.I_C_ElementValue)
        MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
            .getPO(getUser1_ID(), get_TrxName());
  }

  /**
   * Get User Element List 1.
   *
   * @return User defined list element #1
   */
  public int getUser1_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_User1_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set User Element List 1.
   *
   * @param User1_ID User defined list element #1
   */
  public void setUser1_ID(int User1_ID) {
    if (User1_ID < 1) set_Value(COLUMNNAME_User1_ID, null);
    else set_Value(COLUMNNAME_User1_ID, Integer.valueOf(User1_ID));
  }

  public org.compiere.model.I_C_ElementValue getUser2() throws RuntimeException {
    return (org.compiere.model.I_C_ElementValue)
        MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
            .getPO(getUser2_ID(), get_TrxName());
  }

  /**
   * Get User Element List 2.
   *
   * @return User defined list element #2
   */
  public int getUser2_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_User2_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set User Element List 2.
   *
   * @param User2_ID User defined list element #2
   */
  public void setUser2_ID(int User2_ID) {
    if (User2_ID < 1) set_Value(COLUMNNAME_User2_ID, null);
    else set_Value(COLUMNNAME_User2_ID, Integer.valueOf(User2_ID));
  }

  @Override
  public int getTableId() {
    return I_M_InOutLine.Table_ID;
  }
}