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
    throw new UnsupportedOperationException();

  public int getSize() {
    throw new UnsupportedOperationException();
  }
}
