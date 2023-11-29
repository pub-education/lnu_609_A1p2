package sinkingships.model;

import java.util.LinkedList;
import javax.annotation.Nonnull;

/**
 * Abstract class for a player.
 */
public class Board {
  private LinkedList<ShipType> ships;
  // Refactor these to a Point class later.
  private int yMax;
  private char xMax;

  public Board(char xMax, int yMax) {
    this.xMax = xMax;
    this.yMax = yMax;
    ships = new LinkedList<>();
    // loadShips();
  }

  // private void loadShips() {
  //   ships.add(ShipType.AIRCRAFTCARRIER);
  //   ships.add(ShipType.BATTLESHIP);
  //   ships.add(ShipType.CRUISER);
  //   ships.add(ShipType.SUBMARINE);
  //   ships.add(ShipType.DESTROYER);
  // }

  public LinkedList<ShipType> getShips() {
    return new LinkedList<>(this.ships);
  }

  public Integer getMaxWidth() {
    return this.yMax;
  }

  public Integer getMaxHeight() {
    return xMax - 'a' + 1;
  }

  public boolean addShip(@Nonnull Ship ship) {
    // Null check is retained as a defensive programming measure.
    if (ship == null) {
      throw new IllegalArgumentException("Ship cannot be null.");
    }

    try{
      checkPositionWithinBounds(ship.getPosition());
    } catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

  private void checkPositionWithinBounds(Point position) {
    if(position.getHorizontalPosition() > this.yMax || position.getHorizontalPosition() < 0) {
      throw new IllegalArgumentException("Ship position is out of bounds.");
    }
    if(position.getVerticalPosition() > this.xMax) {
      throw new IllegalArgumentException("Ship position is out of bounds.");
    }
  }
}
