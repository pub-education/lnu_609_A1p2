package sinkingships.model;

/**
 * ShipType enum.
 */
public enum ShipType {
  AIRCRAFTCARRIER("Aircraft Carrier", 5),
  BATTLESHIP("Battleship", 4),
  CRUISER("Cruiser", 3),
  SUBMARINE("Submarine", 3),
  DESTROYER("Destroyer", 2);

  private final String name;

  private final int size;

  ShipType(String name, int size) {
    this.name = name;
    this.size = size;
  }

  public String getName() {
    return this.name;
  }

  public int getSize() {
    return this.size;
  }
}
