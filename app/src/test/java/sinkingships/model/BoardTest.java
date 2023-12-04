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
    mockShip = Mockito.mock(Ship.class);
    mockPoint = Mockito.mock(Point.class);
  }

  @Test
  public void shouldHaveTheCorrectWidthAfterCreation() {
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('a');

    sut = new Board(mockPoint);
    assertEquals(horizontalMax, sut.getMaxWidth());
  }

  @Test
  public void shouldHaveTheCorrectHeightAfterCreation() {
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('j');

    sut = new Board(mockPoint);
    int verticalMaxInt = verticalMax - 'a' + 1;
    assertEquals(verticalMaxInt, sut.getMaxHeight());
  }

  @Test
  public void shouldNotReturnTheInternalShipList() {
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('a');

    sut = new Board(mockPoint);
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
  public void shouldThrowIllegalArgumentException() {
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('a');

    sut = new Board(mockPoint);

    assertThrows(IllegalArgumentException.class, () -> {
      sut.addShip(null);
    });
  }

  @Test
  void shouldReturnFalseWhenHorizontalIsTooLarge() {
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax + 1);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('a');

    Ship mockShip = Mockito.mock(Ship.class);
    Mockito.when(mockShip.getPosition()).thenReturn(mockPoint);

    Point boardMockPoint = Mockito.mock(Point.class);
    Mockito.when(boardMockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(boardMockPoint.getVerticalPosition()).thenReturn('j');
    sut = new Board(boardMockPoint);

    assertFalse(sut.addShip(mockShip));
  }

  @Test
  void shouldReturnFalseWhenHorizontalIsTooSmall() {
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(-1);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('a');

    Ship mockShip = Mockito.mock(Ship.class);
    Mockito.when(mockShip.getPosition()).thenReturn(mockPoint);

    Point boardMockPoint = Mockito.mock(Point.class);
    Mockito.when(boardMockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(boardMockPoint.getVerticalPosition()).thenReturn('j');
    sut = new Board(boardMockPoint);

    assertFalse(sut.addShip(mockShip));
  }

  @Test
  public void shouldReturnFalseForShipOutOfBoundsVerticallyGreater() {
    // Check beyond max.
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax - 1);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('k');

    Ship mockShip = Mockito.mock(Ship.class);
    Mockito.when(mockShip.getPosition()).thenReturn(mockPoint);

    Point boardMockPoint = Mockito.mock(Point.class);
    Mockito.when(boardMockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(boardMockPoint.getVerticalPosition()).thenReturn('j');
    sut = new Board(boardMockPoint);

    assertFalse(sut.addShip(mockShip));
  }

  @Test
  public void shouldReturnFalseForShipOutOfBoundsVerticallySmaller() {
    // Check below/before min.
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax - 1);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('`');

    Ship mockShip = Mockito.mock(Ship.class);
    Mockito.when(mockShip.getPosition()).thenReturn(mockPoint);

    Point boardMockPoint = Mockito.mock(Point.class);
    Mockito.when(boardMockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(boardMockPoint.getVerticalPosition()).thenReturn('j');
    sut = new Board(boardMockPoint);

    assertFalse(sut.addShip(mockShip));
  }

  @Test
  public void shouldReturnTrue() {
    Mockito.when(mockPoint.getHorizontalPosition()).thenReturn(horizontalMax - 1);
    Mockito.when(mockPoint.getVerticalPosition()).thenReturn('a');

    Ship mockShip = Mockito.mock(Ship.class);
    Mockito.when(mockShip.getPosition()).thenReturn(mockPoint);

    Point boardMockPoint = Mockito.mock(Point.class);
    Mockito.when(boardMockPoint.getHorizontalPosition()).thenReturn(horizontalMax);
    Mockito.when(boardMockPoint.getVerticalPosition()).thenReturn('j');
    sut = new Board(boardMockPoint);

    assertTrue(sut.addShip(mockShip));
  }

}
