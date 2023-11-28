package sinkingships.model;

/**
 * Ship class.
 */
public class Ship {
  private ShipType shipType;

  public Ship(ShipType shipType) {
    this.shipType = shipType;
  }

  public String getShipType() {
    return this.shipType.getName();
  }

  public Integer getShipSize() {
    return this.shipType.getSize();
  }

  public Object getRotation() {
    return null;
  }

  public Object getPosition() {
    return null;
  }

}
