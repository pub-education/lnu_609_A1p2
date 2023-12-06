package sinkingships.view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import sinkingships.customexception.InvalidInputException;
// import sinkingships.model.Cell;
import sinkingships.model.Player;
import sinkingships.model.Point;
import sinkingships.model.Rotation;
import sinkingships.model.Ship;
import sinkingships.model.ShotResponse;

/**
 * View class for the game.
 */
public class MainView {

  public static final String GREETING = "Welcome to Sinking Ships!";
  private PrintStream outStream;
  private InputStream inStream;

  public MainView(PrintStream outStream) {
    this.outStream = outStream;
  }

  public MainView() {
  }

  public MainView(InputStream testIn) {
    this.inStream = testIn;
  }

  public void displayWelcomeMessage() {
    outStream.println(this.GREETING);
  }

  public Point getShipPlacement(Ship shipMock) {
    char vertical= '`';
    int horizontal = -1;
    try {
      Scanner scanner = new Scanner(this.inStream);
      System.out.println("Enter the position of your " + shipMock.getShipType() + " (e.g. a1): ");
      String input = scanner.nextLine();
      if (input.length() != 2) {
        throw new InvalidInputException("Invalid input. Please enter a letter and a number.");
      }
      vertical = input.charAt(0);
      horizontal = Integer.parseInt(input.substring(1));
      return new Point(horizontal, vertical);
    } catch (Exception e) {
      return null;
    }
  }

}
