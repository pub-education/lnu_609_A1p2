package sinkingships.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sinkingships.controller.Player;
import sinkingships.model.ShotResponse;
import sinkingships.model.Board;
import sinkingships.model.Cell;
import sinkingships.model.ModelPlayer;

/**
 * Unit test for the MainView class.
 */
public class MainViewTest {
  private PrintStream printStream;
  private InputStream inputStream;
  private MainView mainView;
  private PipedOutputStream pos;
  private PipedInputStream pis;

  /**
   * Set up the test fixture.
   *
   * @throws IOException if an I/O error occurs.
   */
  @BeforeEach
  public void setUp() throws IOException {
    this.printStream = mock(PrintStream.class);
    this.inputStream = mock(InputStream.class);
    this.mainView = new MainView(printStream, inputStream);
    this.pos = new PipedOutputStream();
    this.pis = new PipedInputStream(pos);
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
    verify(printStream, atLeastOnce()).println(expected);
  }

  @Test
  public void boardArrayToStringShouldBeAbleToCreateStringFromArrayOfCells() {
    Cell[][] mockBoardArray = createMockBoardArray(10, 10);
    String actual = mainView.boardArrayToString(mockBoardArray);
    String expected =
          "   1  2  3  4  5  6  7  8  9  10  \n"
        + "A  -  -  -  -  -  -  -  -  -  -  \n"
        + "B  -  -  -  -  -  -  -  -  -  -  \n"
        + "C  -  -  -  -  -  -  -  -  -  -  \n"
        + "D  -  -  -  -  -  -  -  -  -  -  \n"
        + "E  -  -  -  -  -  -  -  -  -  -  \n"
        + "F  -  -  -  -  -  -  -  -  -  -  \n"
        + "G  -  -  -  -  -  -  -  -  -  -  \n"
        + "H  -  -  -  -  -  -  -  -  -  -  \n"
        + "I  -  -  -  -  -  -  -  -  -  -  \n"
        + "J  -  -  -  -  -  -  -  -  -  -  \n";

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
    verify(printStream, atLeastOnce()).println(expectedBoardString);
  }

  @Test
  public void mainViewShouldBeAbleToClearScreen() {
    mainView.clearScreen();
    verify(printStream, times(50)).println();
  }

  // Consider doing this as a manual test instead.
  // It depends on simulated user input and may be flaky.
  @Test
  public void mainViewShouldBeAbleToPressEnterToContinue()
      throws IOException, InterruptedException {
    MainView mainView = new MainView(printStream, pis);
    Thread thread = new Thread(() -> {
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
    verify(printStream, atLeastOnce()).println("Press enter to continue...");
  }

  // Consider doing this as a manual test instead.
  // It depends on simulated user input and may be flaky.
  @Test
  public void shouldBeAbleToCollectInputfromUser() throws IOException {
    MainView mainView = new MainView(printStream, pis);
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
    String simulatedUserInput = "A1\n";
    InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
    MainView mainView = new MainView(printStream, inputStream);
    String regex = "^[A-J][1-9]$";
    String actual = mainView.getUserInputCoordinates(regex, "Only A1-J9 is allowed");
    verify(printStream).println("Enter coordinate: ");
    Assertions.assertEquals("A1", actual);
  }

  @Test
  public void displayEnumText_shouldBeAbleToDisplayMessageMatchedWithEnumValue() {
    mainView.displayAttackResult(ShotResponse.HIT);
    verify(printStream).println("Hit!");
    mainView.displayAttackResult(ShotResponse.MISS);
    verify(printStream).println("Miss!");
    mainView.displayAttackResult(ShotResponse.HIT_AND_SUNK);
    verify(printStream).println("Hit and sunk!");
  }

  // Should be able to Collect a rotation from user and return a corresponding enum value
  @Test
  public void shouldBeAbleToCollectRotationFromUser() {
    String simulatedUserInput = "1\n";
    InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
    MainView mainView = new MainView(printStream, inputStream);
    Board.Rotation actual = mainView.getUserInputRotation();
    verify(printStream).println(
        "Enter rotation:\n 1 = North\n 2 = West\n 3 = South\n 4 = East\n): ");
    Assertions.assertEquals(Board.Rotation.NORTH, actual);
  }

  @Test
  public void shouldBeAbleToDisplayWinner() {
    String simulatedUserInput = "1\n";
    InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
    MainView mainView = new MainView(printStream, inputStream);
    ModelPlayer player1 = mock(ModelPlayer.class);
    when(player1.getName()).thenReturn("HumanPlayer");
    mainView.displayWinner(player1);
    verify(printStream).println("HumanPlayer won!");
    ModelPlayer player2 = mock(ModelPlayer.class);
    when(player2.getName()).thenReturn("ComputerPlayer");
    mainView.displayWinner(player2);
    verify(printStream).println("ComputerPlayer won!");
  }

  @Test
  public void shouldBeAbleToCollectDecisionFromUser() {
    String simulatedUserInput = "P\n";
    InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
    MainView mainView = new MainView(printStream, inputStream);
    boolean actual = mainView.getUserInputPlayAgainOrQuit();
    verify(printStream).println("Would you like to:\n P = Play again?\n Q = Quit\n");
    Assertions.assertEquals(true, actual);
  }

  @Test
  public void shouldBeAbleToDisplayGoodbyeMessage() {
    mainView.displayGoodbyeMessage();
    verify(printStream).println("Goodbye!");
  }

  @Test
  public void shouldBeAbleToPlaceCursorAtGivenCoordinate() {
    mainView.setCursorPosition(1, 1);
    verify(printStream).printf("\033[%d;%dH", 2, 2);
  }
}
