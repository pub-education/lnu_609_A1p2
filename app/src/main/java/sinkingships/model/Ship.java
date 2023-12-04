package sinkingships.model;

/**
 * Ship class.
 */
public class Ship {
  private ShipType shipType;

  public Ship(ShipType shipType) {
    this.shipType = shipType;
  }

  public ShipType getShipType() {
    return this.shipType;
  }

  public Integer getShipSize() {
    return this.shipType.getSize();
  }

  public Rotation getRotation() {
    return null;
  }

  public Point getPosition() {
    return null;
  }

}
