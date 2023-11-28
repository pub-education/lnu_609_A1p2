package sinkingships.model;

import java.util.LinkedList;

/**
 * Abstract class for a player.
 */
public class Board {
  private LinkedList<ShipType> ships;

  public Board(char xMax, int yMax) {
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
    return 10;
  }
}
