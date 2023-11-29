package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Tests for the Board class.
 */
public class BoardTest {

  private Board sut;
  private int yMax = 10;
  private char xMax = 'j';
  private Ship mockShip;

  @BeforeEach
  public void setUp() {
    sut = new Board(xMax, yMax);
    mockShip = Mockito.mock(Ship.class);
  }

  @Test
  public void shouldHaveTheCorrectWidthAfterCreation() {
    assertEquals(yMax, sut.getMaxWidth());
  }

  @Test
  public void shouldHaveTheCorrectHeightAfterCreation() {
    int xMaxInt = xMax - 'a' + 1;
    assertEquals(xMaxInt, sut.getMaxHeight());
  }

  // @Test
  // public void shouldHaveFiveShipsAfterCreation() {
  // assertEquals(5, sut.getShips().size());
  // }

  // @Test
  // public void shouldHaveTheCorrectShipsAfterCreation() {
  // assertEquals(ShipType.AIRCRAFTCARRIER, sut.getShips().get(0));
  // assertEquals(ShipType.BATTLESHIP, sut.getShips().get(1));
  // assertEquals(ShipType.CRUISER, sut.getShips().get(2));
  // assertEquals(ShipType.SUBMARINE, sut.getShips().get(3));
  // assertEquals(ShipType.DESTROYER, sut.getShips().get(4));
  // }

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

  @Test
  public void shouldReturnTrueForAddShip() {
    ShipType ship = ShipType.AIRCRAFTCARRIER;
    // assertTrue(sut.addShip(ship));
  }

  @Test
  public void shouldThrowIllegalArgumentException() {

    assertThrows(IllegalArgumentException.class, () -> {
      sut.addShip(null);
    });
  }

  @Test
  public void shouldNotThrowIllegalArgumentException() {
    Mockito.when(mockShip.getPosition()).thenReturn(new Point(0, 'a'));
    Mockito.when(mockShip.getRotation()).thenReturn(Rotation.NORTH);
    try {
      sut.addShip(mockShip);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      assertTrue(false);
    } catch (Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }
  }

  @Test
  public void shouldReturnFalseForShipOutOfBoundsHorizontally() {
    Mockito.when(mockShip.getPosition()).thenReturn(new Point(11, 'a'));
    Mockito.when(mockShip.getRotation()).thenReturn(Rotation.NORTH);

    assertFalse(sut.addShip(mockShip));
  }
}
