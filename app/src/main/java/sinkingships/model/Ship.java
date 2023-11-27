package sinkingships.model;

public class Ship {
  private ShipType shipType;

	public Ship(ShipType shipType) {
    this.shipType = shipType;
	}

  public Object getShipType() {
    return this.shipType.getName();
  }
  
}
