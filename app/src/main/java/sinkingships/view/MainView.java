package sinkingships.view;

import sinkingships.customexception.InvalidInputException;
import sinkingships.customexception.InvalidRotationException;
import sinkingships.model.Board;
import sinkingships.model.Cell;

import java.io.InputStream;
import java.io.PrintStream;

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
    int height = boardArray.length;
    int width = boardArray[0].length;
    boardString.append("   ");
    for (int x = 1; x <= width; x++) {
      boardString.append(x + "  ");
    }
    boardString.append("\n");

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

  public void clearScreen() {
    for (int i = 0; i < 50; i++) {
        out.println();
    }
  }

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

  protected void checkInput(String input, String regex, String allowed) throws InvalidInputException {
    if (input == null || input.equals("")) {
      throw new InvalidInputException(allowed);
    }
    input = input.toUpperCase();
    if (!input.matches(regex)) {
      throw new InvalidInputException(allowed);
    }
  }

  public void displayAttackResult(Board.Result result) {
    switch (result) {
      case HIT:
        displayMessage("Hit!");
        break;
      case MISS:
        displayMessage("Miss!");
        break;
      case HIT_AND_SUNK:
        displayMessage("Hit and sunk!");
        break;
    }
  }

  public void setCursorPosition(int row, int col) {
    out.printf("\033[%d;%dH", row + 1, col + 1);
  }

  public void displayGoodbyeMessage() {
    clearScreen();
    setCursorPosition(1, 1);
    displayMessage("Goodbye!");
    pressEnterToContinue();
  }

  public Board.Rotation getUserInputRotation () {
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
        }
      } catch (Exception e) {
        displayMessage(e.getMessage());
      }
    }
    return Board.Rotation.NONE;
  }
}
