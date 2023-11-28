package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.lang.reflect.Field;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Board class.
 */
public class BoardTest {

  Board sut;
  int yMax = 5;
  char xMax = 'c';

  @BeforeEach
  public void setUp() {
    sut = new Board(xMax, yMax);
  }

  @Test
  public void shouldHaveTheCorrectWidthAfterCreation() {
    assertEquals(yMax, sut.getMaxWidth());
  }

  @Test
  public void shouldHaveTheCorrectHeightAfterCreation() {
    assertEquals(3, sut.getMaxHeight());
  }

  @Test
  public void shouldHaveFiveShipsAfterCreation() {
    assertEquals(5, sut.getShips().size());
  }

  @Test
  public void shouldHaveTheCorrectShipsAfterCreation() {
    assertEquals(ShipType.CARRIER, sut.getShips().get(0));
    assertEquals(ShipType.BATTLESHIP, sut.getShips().get(1));
    assertEquals(ShipType.CRUISER, sut.getShips().get(2));
    assertEquals(ShipType.SUBMARINE, sut.getShips().get(3));
    assertEquals(ShipType.DESTROYER, sut.getShips().get(4));
  }

  @Test
  public void shouldNotReturnTheInternalShipList() {
    LinkedList<ShipType> returnedShips = sut.getShips();

    LinkedList<ShipType> internalShips = null;
    try {
      // Using the reflection API to access the private field "ships" of the Board
      // class.
      Field field = Board.class.getDeclaredField("ships");
      // Making the private field "ships" accessible, so we can read it.
      field.setAccessible(true);
      // Getting the value of the private field "ships" of the Board class and casting
      // it to a LinkedList<ShipType>.
      internalShips = (LinkedList<ShipType>) field.get(sut);

      assertNotSame(internalShips, returnedShips,
          "The returned list should be a copy of the internal list.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
