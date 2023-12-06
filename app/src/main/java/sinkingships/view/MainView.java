package sinkingships.view;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
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

  public MainView() {
  }

  public void displayWelcomeMessage() {
    System.out.println(this.GREETING);
  }

  /**
   * Placing the Player's ships.
   *
   * @param ship - the ship to be placed
   * @return the point where the ship is placed
   */
  public Point getShipPlacement(Ship ship) {
    char vertical = '`';
    int horizontal = -1;
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());

    try {
      System.out.println("Enter the position of your " + ship.getShipType() + " (e.g. a1): ");
      String input = scanner.nextLine();
      if (input.length() != 2) {
        throw new IllegalArgumentException("Invalid input. Please enter a letter and a number.");
      }
      vertical = input.charAt(0);
      horizontal = Integer.parseInt(input.substring(1));
      return new Point(horizontal, vertical);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage());
    } catch (Exception e) {
      return null;
      // throw new Exception(e.getMessage());
    } finally {
      scanner.close();
    }
  }

}
