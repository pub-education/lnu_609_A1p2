package sinkingships.model;

import java.util.LinkedList;
import javax.annotation.Nonnull;

/**
 * Abstract class for a player.
 */
public class Board {
  private LinkedList<ShipType> ships;
  // Refactor these to a Point class later.
  private char verticalMax;
  private int horizontalMax;

  /**
   * Constructor for the Board class.
   *
   * @param maxPoint The maximum point of the board.
   */
  public Board(Point maxPoint) {
    this.horizontalMax = maxPoint.getHorizontalPosition();
    this.verticalMax = maxPoint.getVerticalPosition();
    ships = new LinkedList<>();
    // loadShips();
  }

  // private void loadShips() {
  // ships.add(ShipType.AIRCRAFTCARRIER);
  // ships.add(ShipType.BATTLESHIP);
  // ships.add(ShipType.CRUISER);
  // ships.add(ShipType.SUBMARINE);
  // ships.add(ShipType.DESTROYER);
  // }

  public LinkedList<ShipType> getShips() {
    return new LinkedList<>(this.ships);
  }

  public int getMaxWidth() {
    return this.horizontalMax;
  }

  public int getMaxHeight() {
    return this.verticalMax - 'a' + 1;
  }

  /**
   * Adds a ship to the board.
   *
   * @param ship The ship to be added.
   * @return True if the ship was added successfully, false otherwise.
   */
  public boolean addShip(@Nonnull Ship ship) {
    // Null check is retained as a defensive programming measure.
    if (ship == null) {
      throw new IllegalArgumentException("Ship cannot be null.");
    }

    try {
      checkPositionWithinBounds(ship.getPosition());
    } catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

  private void checkPositionWithinBounds(Point position) {
    if (position.getHorizontalPosition() > this.verticalMax
        || position.getHorizontalPosition() < 0) {
      throw new IllegalArgumentException("Ship position is out of bounds.");
    }
    if (position.getVerticalPosition() > this.horizontalMax
        || position.getVerticalPosition() < 'a') {
      throw new IllegalArgumentException("Ship position is out of bounds.");
    }
  }
}
