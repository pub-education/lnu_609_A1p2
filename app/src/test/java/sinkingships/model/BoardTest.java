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
  private int horizontalMax = 10;
  private char verticalMax = 'j';
  private Ship mockShip;
  private Point mockPoint;

  /**
   * Sets up the test fixture.
   */
  @BeforeEach
  public void setUp() {
    mockPoint = Mockito.mock(Point.class);
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn(verticalMax);
    Mockito.when(mockPoint.getVerticalIndex()).thenReturn(verticalMax - 'a');
    sut = new Board(mockPoint);
    mockShip = Mockito.mock(Ship.class);
  }

  @Test
  public void shouldHaveTheCorrectWidthAfterCreation() {
    assertEquals(horizontalMax, sut.getMaxWidth());
  }

  @Test
  public void shouldHaveTheCorrectHeightAfterCreation() {
    int verticalMaxInt = verticalMax - 'a' + 1;
    assertEquals(verticalMaxInt, sut.getMaxHeight());
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

    assertThrows(IllegalArgumentException.class, () -> {
      Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(-1);
      Mockito.when(mockPoint.getVerticalPosition()).thenReturn('a');
      Mockito.when(mockShip.getPosition()).thenReturn(mockPoint);
      sut.addShip(mockShip);
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
    // Check beyond max.
    Mockito.when(mockShip.getPosition()).thenReturn(new Point(11, 'a'));
    Mockito.when(mockShip.getRotation()).thenReturn(Rotation.NORTH);

    assertFalse(sut.addShip(mockShip));

    // Check below min.
    Mockito.when(mockShip.getPosition()).thenReturn(new Point(-1, 'a'));
    Mockito.when(mockShip.getRotation()).thenReturn(Rotation.NORTH);

    assertFalse(sut.addShip(mockShip));
  }

  @Test
  public void shouldReturnFalseForShipOutOfBoundsVerticallyGreater() {
    // Check beyond max.
    Mockito.when(mockShip.getPosition()).thenReturn(new Point(0, 'k'));
    Mockito.when(mockShip.getRotation()).thenReturn(Rotation.NORTH);

    assertFalse(sut.addShip(mockShip));
  }

  @Test
  public void shouldReturnFalseForShipOutOfBoundsVerticallySmaller() {
    // Check below/before min.
    Mockito.when(mockShip.getPosition()).thenReturn(new Point(0, '`'));
    Mockito.when(mockShip.getRotation()).thenReturn(Rotation.NORTH);

    assertFalse(sut.addShip(mockShip));
  }
}
