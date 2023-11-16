package sinking_ships.view;

import sinking_ships.model.Board;
import sinking_ships.model.Cell;

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
      if (input == null || input.equals("")) {
        break;
      }
      input = input.toUpperCase();
      if (input.matches(regex)) {
        return input;
      } else {
        out.println("Invalid input! " + allowed + " Try again:");
      }
      attempts++;
    }
    throw new RuntimeException("Too many invalid inputs! Sleep on it!");
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
}
