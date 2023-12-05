package sinkingships.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
  private ByteArrayInputStream testIn;

  @BeforeEach
  void setSystemIn() {
    String input = "c4\n";
    testIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(testIn);
  }

  @AfterEach
  void restoreSystemIn() {
    System.setIn(originalIn);
  }

  @Test
  void displayWelcomeMessageOutputGreeting() {
    PrintStream outStreamMock = mock(PrintStream.class);

    var sut = new MainView(outStreamMock);
    sut.displayWelcomeMessage();

    verify(outStreamMock).println(sut.GREETING);
  }

  @Test
  void shouldGetInputToPlaceShipOnBoard() {
    Ship shipMock = mock(Ship.class);
    Mockito.when(shipMock.getShipType()).thenReturn(ShipType.BATTLESHIP);

    var sut = new MainView();
    var shipPlacement = sut.getShipPlacement(shipMock);

    Point pointMock = mock(Point.class);
    Mockito.when(pointMock.getHorizontalPosition()).thenReturn(4);
    Mockito.when(pointMock.getVerticalPosition()).thenReturn('c');
    assertEquals('c', shipPlacement.getVerticalPosition());
    assertEquals(4,  shipPlacement.getHorizontalPosition());
  }

}
