package sinkingships.model;

import java.util.LinkedList;

/**
 * Abstract class for a player.
 */
public class Board {
  private LinkedList<ShipType> ships;
  private int yMax;
  private char xMax;

  public Board(char xMax, int yMax) {
    this.xMax = xMax;
    this.yMax = yMax;
    ships = new LinkedList<>();
    loadShips();
  }

  private void loadShips() {
    ships.add(ShipType.CARRIER);
    ships.add(ShipType.BATTLESHIP);
    ships.add(ShipType.CRUISER);
    ships.add(ShipType.SUBMARINE);
    ships.add(ShipType.DESTROYER);
  }

  public LinkedList<ShipType> getShips() {
    return new LinkedList<>(this.ships);
  }

  public Integer getMaxWidth() {
    return this.yMax;
  }

  public Integer getMaxHeight() {
    return xMax - 'a' + 1;
  }
}
