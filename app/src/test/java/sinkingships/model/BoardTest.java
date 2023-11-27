package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.lang.reflect.Field;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

/**
 * Tests for the Board class.
 */
public class BoardTest {

  @Test
  public void shouldHaveFiveShipsAfterCreation() {
    Board sut = new Board();
    assertEquals(5, sut.getShips().size());
  }

  @Test
  public void shouldHaveTheCorrectShipsAfterCreation() {
    Board sut = new Board();
    assertEquals(ShipType.CARRIER, sut.getShips().get(0));
    assertEquals(ShipType.BATTLESHIP, sut.getShips().get(1));
    assertEquals(ShipType.CRUISER, sut.getShips().get(2));
    assertEquals(ShipType.SUBMARINE, sut.getShips().get(3));
    assertEquals(ShipType.DESTROYER, sut.getShips().get(4));
  }

  @Test
  public void shouldNotReturnTheInternalShipList() {
    Board sut = new Board();
    LinkedList<ShipType> returnedShips = sut.getShips();

    LinkedList<ShipType> internalShips = null;
    try {
      Field field = Board.class.getDeclaredField("ships");
      field.setAccessible(true);
      internalShips = (LinkedList<ShipType>) field.get(sut);

      assertNotSame(internalShips, returnedShips, "The returned list should be a copy of the internal list.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
