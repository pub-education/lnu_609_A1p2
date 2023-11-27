package sinkingships.model;

public class Ship {
  private ShipType shipType;

	public Ship(ShipType shipType) {
    this.shipType = shipType;
	}

  public String getShipType() {
    return this.shipType.getName();
  }

  public Integer getShipSize() {
    return 5;
  }
  
}
