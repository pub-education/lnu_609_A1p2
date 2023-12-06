package sinkingships.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sinkingships.model.Point;
import sinkingships.model.Ship;
import sinkingships.model.ShipType;

/**
 * Unit test for the MainView class.
 */
public class MainViewTest {

  private final InputStream originalIn = System.in;
  private final PrintStream originalOut = System.out;
  private ByteArrayInputStream testIn;

  @BeforeEach
  void setSystemIn() {
    
  }

  @AfterEach
  void restoreSystemIo() {
    System.setIn(originalIn);
    System.setOut(originalOut);
  }

  @Test
  void displayWelcomeMessageOutputGreeting() {
    PrintStream outStreamMock = mock(PrintStream.class);
    System.setOut(outStreamMock);

    var sut = new MainView();
    sut.displayWelcomeMessage();

    verify(outStreamMock).println(sut.GREETING);
  }

  @Test
  void shouldGetInputToPlaceShipOnBoard() {
    String input = "c4\n";
    testIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(testIn);
    Ship shipMock = mock(Ship.class);
    Mockito.when(shipMock.getShipType()).thenReturn(ShipType.BATTLESHIP);

    var sut = new MainView();
    Point shipPlacement = new Point(0, 'a');
    try {
      shipPlacement = sut.getShipPlacement(shipMock);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Point pointMock = mock(Point.class);
    Mockito.when(pointMock.getHorizontalPosition()).thenReturn(4);
    Mockito.when(pointMock.getVerticalPosition()).thenReturn('c');
    assertEquals('c', shipPlacement.getVerticalPosition());
    assertEquals(4,  shipPlacement.getHorizontalPosition());
  }

  @Test
  void shouldThrowIllegalArgumentExceptionForInputStringOfMoreThanThreeCharacters() {
    String input = "c114\n";
    testIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(testIn);

    Ship shipMock = mock(Ship.class);
    Mockito.when(shipMock.getShipType()).thenReturn(ShipType.BATTLESHIP);

    var sut = new MainView();
    assertThrows(IllegalArgumentException.class, () -> {
      sut.getShipPlacement(shipMock);
    });
  }

  @Test
  void shouldThrowIllegalArgumentExceptionForInputStringWhereCharTooLow() {
    String input = "`4\n";
    testIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(testIn);

    Ship shipMock = mock(Ship.class);
    Mockito.when(shipMock.getShipType()).thenReturn(ShipType.BATTLESHIP);

    var sut = new MainView();
    assertThrows(IllegalArgumentException.class, () -> {
      sut.getShipPlacement(shipMock);
    });
  }

  @Test
  void shouldThrowIllegalArgumentExceptionForInputStringWhereCharTooHigh() {
    String input = "{4\n";
    testIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(testIn);

    Ship shipMock = mock(Ship.class);
    Mockito.when(shipMock.getShipType()).thenReturn(ShipType.BATTLESHIP);

    var sut = new MainView();
    assertThrows(IllegalArgumentException.class, () -> {
      sut.getShipPlacement(shipMock);
    });
  }

  @Test
  void shouldThrowIllegalArgumentExceptionForInputStringWhereNumberNotDigit() {
    String input = "ac4\n";
    testIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(testIn);

    Ship shipMock = mock(Ship.class);
    Mockito.when(shipMock.getShipType()).thenReturn(ShipType.BATTLESHIP);

    var sut = new MainView();
    assertThrows(IllegalArgumentException.class, () -> {
      sut.getShipPlacement(shipMock);
    });
  }

}
