package sinkingships.model;

/**
 * Enum for the rotation of a ship.
 */
public enum Rotation {
  NORTH("North"),
  WEST("West"),
  SOUTH("South"),
  EAST("East"),
  NONE("None");

  private final String direction;
  
  Rotation(String direction) {
    this.direction = direction;
  }

  @Override
  public String toString() {
    return direction;
  }
}
