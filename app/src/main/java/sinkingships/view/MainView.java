package sinkingships.view;

import java.io.InputStream;
import java.io.PrintStream;
import sinkingships.customexception.InvalidInputException;
import sinkingships.model.Board;
import sinkingships.model.Cell;
import sinkingships.model.ModelPlayer;
import sinkingships.model.ShotResponse;

/**
 * View class for the game.
 */
public class MainView {

  private PrintStream out;
  private InputStream in;

  public MainView(PrintStream printStream, InputStream inputStream) {
    this.out = printStream;
    this.in = inputStream;
  }

  public void displayMessage(String message) {
    out.println(message);
  }

  protected String boardArrayToString(Cell[][] boardArray) {
    StringBuilder boardString = new StringBuilder();
    int width = boardArray[0].length;
    boardString.append("   ");
    for (int x = 1; x <= width; x++) {
      boardString.append(x + "  ");
    }
    boardString.append("\n");
    int height = boardArray.length;
    for (int y = height - 1; y >= 0; y--) {
      boardString.append((char) ('A' + (height - 1 - y))).append("  ");
      for (int x = 0; x < width; x++) {
        boardString.append(boardArray[y][x].getValue()).append("  ");
      }
      boardString.append("\n");
    }
    return boardString.toString();
  }

  public void displayBoard(Cell[][] boardArray) {
    String boardString = boardArrayToString(boardArray);
    displayMessage(boardString);
  }

  /**
   * Clears the screen.
   */
  public void clearScreen() {
    for (int i = 0; i < 50; i++) {
      out.println();
    }
  }

  /**
   * Displays a message to the user and waits for user to press enter.
   */
  public void pressEnterToContinue() {
    displayMessage("Press enter to continue...");
    try {
      in.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected String getUserInput() {
    try {
      byte[] buffer = new byte[100];
      int length = in.read(buffer);
      if (length == -1) {
        return "";
      }
      return new String(buffer, 0, length).trim();
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * Asks user for coordinates and validates input.
   *
   * @param regex regex to validate input
   * @param allowed allowed characters
   * @return validated input
   */
  public String getUserInputCoordinates(String regex, String allowed) {
    displayMessage("Enter coordinate: ");
    int attempts = 0;
    while (attempts < 3) {
      String input = getUserInput();
      try {
        checkInput(input, regex, allowed);
        return input;
      } catch (Exception e) {
        displayMessage(e.getMessage());
      }
      attempts++;
    }
    throw new RuntimeException("Too many invalid inputs! Sleep on it!");
  }

  protected void checkInput(String input, String regex, String allowed)
      throws InvalidInputException {
    if (input == null || input.equals("")) {
      throw new InvalidInputException(allowed);
    }
    input = input.toUpperCase();
    if (!input.matches(regex)) {
      throw new InvalidInputException(allowed);
    }
  }

  /**
   * Displays a message to the user that the attack was a hit, miss or sunk.
   *
   * @param hit result of the attack
   */
  public void displayAttackResult(ShotResponse hit) {
    switch (hit) {
      case HIT:
        displayMessage("Hit!");
        break;
      case MISS:
        displayMessage("Miss!");
        break;
      case HIT_AND_SUNK:
        displayMessage("Hit and sunk!");
        break;
      default:
        break;
    }
  }

  public void setCursorPosition(int row, int col) {
    out.printf("\033[%d;%dH", row + 1, col + 1);
  }

  /**
   * Displays a goodbye message and waits for user to press enter.
   */
  public void displayGoodbyeMessage() {
    clearScreen();
    setCursorPosition(1, 1);
    displayMessage("Goodbye!");
    pressEnterToContinue();
  }

  /**
   * Asks user for rotation and validates input.
   *
   * @return validated input
   */
  public Board.Rotation getUserInputRotation() {
    displayMessage("Enter rotation:\n 1 = North\n 2 = West\n 3 = South\n 4 = East\n): ");
    int attempts = 0;
    while (attempts < 4) {
      String input = getUserInput();
      try {
        checkInput(input, "^[1-4]$", "1-4");
        attempts++;
        switch (input) {
          case "1":
            return Board.Rotation.NORTH;
          case "2":
            return Board.Rotation.WEST;
          case "3":
            return Board.Rotation.SOUTH;
          case "4":
            return Board.Rotation.EAST;
          default:
            break;
        }
      } catch (Exception e) {
        displayMessage(e.getMessage());
      }
    }
    return Board.Rotation.NONE;
  }

  /**
   * Asks user if they want to play again or quit.
   *
   * @return true if user wants to play again, false if user wants to quit.
   */
  public boolean getUserInputPlayAgainOrQuit() {
    displayMessage("Would you like to:\n P = Play again?\n Q = Quit\n");
    int attempts = 0;
    while (attempts < 3) {
      String input = getUserInput();
      try {
        checkInput(input, "^[PQ]$", "P or Q");
        attempts++;
        switch (input) {
          case "P":
            return true;
          case "Q":
            return false;
          default:
            break;
        }
      } catch (Exception e) {
        displayMessage(e.getMessage());
      }
    }
    return false;
  }

  public void displayWinner(ModelPlayer player) {
    displayMessage(player.getName() + " won!");
  }
}
