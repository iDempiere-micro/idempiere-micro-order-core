package org.compiere.order;

/** @author hengsin */
public interface IShipmentProcessorFactory {

  /**
   * Create new shipment processor instance
   *
   * @param className
   * @return shipment processor instance
   */
  public IShipmentProcessor newShipmentProcessorInstance(String className);
}
