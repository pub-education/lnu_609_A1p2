package sinkingships.model;


public enum ShipType {
  CARRIER("Carrier", 5);

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
