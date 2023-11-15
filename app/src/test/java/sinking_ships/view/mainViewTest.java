package sinking_ships.view;

import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sinking_ships.model.Board;
import sinking_ships.model.Cell;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class mainViewTest {

  private PrintStream printstream;
  private InputStream inputStream;
  private MainView mainView;

  @BeforeEach
  public void setUp() {
    this.printstream = mock(PrintStream.class);
    this.inputStream = mock(InputStream.class);
    this.mainView = new MainView(printstream, inputStream);
  }

  @Test
  public void mainViewExists() {
    assertNotNull(mainView, "mainView should be a class");
  }

  @Test
  public void mainViewShouldBeAbleToDisplayMessage() {
    String message = "Hello World!";
    String expected = message;
    mainView.displayMessage(message);
    verify(printstream, atLeastOnce()).println(expected);
  }

  @Test
  public void boardArrayToStringShouldBeAbleToCreateStringFromArrayOfCells() {
    Cell[][] mockBoardArray = createMockBoardArray(10, 10);
    String actual = mainView.boardArrayToString(mockBoardArray);
    String expected =
     "   1  2  3  4  5  6  7  8  9  10  \n" +
     "A  -  -  -  -  -  -  -  -  -  -  \n" +
     "B  -  -  -  -  -  -  -  -  -  -  \n" +
     "C  -  -  -  -  -  -  -  -  -  -  \n" +
     "D  -  -  -  -  -  -  -  -  -  -  \n" +
     "E  -  -  -  -  -  -  -  -  -  -  \n" +
     "F  -  -  -  -  -  -  -  -  -  -  \n" +
     "G  -  -  -  -  -  -  -  -  -  -  \n" +
     "H  -  -  -  -  -  -  -  -  -  -  \n" +
     "I  -  -  -  -  -  -  -  -  -  -  \n" +
     "J  -  -  -  -  -  -  -  -  -  -  \n";

    assertEquals(expected, actual);
  }

  private Cell[][] createMockBoardArray(int width, int height) {
    Cell[][] mockBoardArray = new Cell[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Cell mockCell = mock(Cell.class);
        when(mockCell.getValue()).thenReturn("-");
        mockBoardArray[y][x] = mockCell;
      }
    }
    return mockBoardArray;
  }

  @Test
  public void mainViewShouldBeAbleToDisplayBoard() {
    Cell[][] mockBoardArray = createMockBoardArray(10, 10);
    mainView.displayBoard(mockBoardArray);
    String expectedBoardString = mainView.boardArrayToString(mockBoardArray);
    verify(printstream, atLeastOnce()).println(expectedBoardString);
  }

  @Test
  public void mainViewShouldBeAbleToClearScreen() {
    mainView.clearScreen();
    verify(printstream, times(50)).println();
  }


  // view should have a method to display clear the screen

  // view should have a method to press enter to continue

  // view should have a method to collect user input

  // view should have a method to display a message


}
