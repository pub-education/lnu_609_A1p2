package sinking_ships.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
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

  // Consider doing this as a manual test instead.
  // It depends on simulated user input and may be flaky.
  @Test
  public void mainViewShouldBeAbleToPressEnterToContinue() throws IOException, InterruptedException {
      PipedOutputStream pos = new PipedOutputStream();
      PipedInputStream pis = new PipedInputStream(pos);
      MainView mainView = new MainView(printstream, pis);
      Thread thread = new Thread(()-> {
        try {
          mainView.pressEnterToContinue();
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
      thread.start();
      pos.write("\n".getBytes());
      pos.flush();
      pos.close();
      Thread.sleep(1000);
      verify(printstream, atLeastOnce()).println("Press enter to continue...");
  }

  // Consider doing this as a manual test instead.
  // It depends on simulated user input and may be flaky.
  @Test
  public void shouldBeAbleToCollectInputfromUser() throws IOException {
    PipedOutputStream pos = new PipedOutputStream();
    PipedInputStream pis = new PipedInputStream(pos);
    MainView mainView = new MainView(printstream, pis);
    new Thread(() -> {
        mainView.getUserInput();
    }).start();
    pos.write("A1".getBytes());
    pos.flush();
    pos.close();
    String actual = mainView.getUserInput();
    String expected = "A1";
    assertEquals(expected, actual);
  }

  @Test
  public void shouldBeAbleToCollectValidCoordinateFromUser() {
    PrintStream printstream = mock(PrintStream.class);
    String simulatedUserInput = "A1\n";
    InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
    MainView mainView = new MainView(printstream, inputStream);
    String regex = "^[A-J][1-9]$";
    String actual = mainView.getUserInputCoordinates(regex, "Only A1-J9 is allowed");
    verify(printstream).println("Enter coordinate: ");
    Assertions.assertEquals("A1", actual);
  }

  @Test
  public void displayEnumText_shouldBeAbleToDisplayMessageMatchedWithEnumValue() {
    mainView.displayAttackResult(Board.Result.HIT);
    verify(printstream).println("Hit!");
    mainView.displayAttackResult(Board.Result.MISS);
    verify(printstream).println("Miss!");
    mainView.displayAttackResult(Board.Result.HIT_AND_SUNK);
    verify(printstream).println("Hit and sunk!");
  }

  // Should be able to Collect a rotation from user and return a corresponding enum value
  @Test
  public void shouldBeAbleToCollectRotationFromUser() {
    PrintStream printstream = mock(PrintStream.class);
    String simulatedUserInput = "1\n";
    InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
    MainView mainView = new MainView(printstream, inputStream);
    String actual = mainView.getUserInputRotation();
    verify(printstream).println("Enter rotation (1 = North, 2 = West, 3 = South, 4 = East): ");
    Assertions.assertEquals("1", actual);
  }

  // Should be able to present a winner either by player or computer (passed as object-copy).
  // pointless at this stage but could be used to extract game statistics.

  // Should be able to collect decision on whether to play again or quit.

  @Test
  public void shouldBeAbleToDisplayGoodbyeMessage() {
    mainView.displayGoodbyeMessage();
    verify(printstream).println("Goodbye!");
  }

  @Test
  public void shouldBeAbleToPlaceCursorAtGivenCoordinate() {
    mainView.setCursorPosition(1, 1);
    verify(printstream).printf("\033[%d;%dH", 2, 2);
  }
}
