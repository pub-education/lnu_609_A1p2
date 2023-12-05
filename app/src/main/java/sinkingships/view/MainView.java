package sinkingships.view;

import java.io.InputStream;
import java.io.PrintStream;
import sinkingships.customexception.InvalidInputException;
// import sinkingships.model.Cell;
import sinkingships.model.Player;
import sinkingships.model.Rotation;
import sinkingships.model.ShotResponse;

/**
 * View class for the game.
 */
public class MainView {

  public static final String GREETING = "Welcome to Sinking Ships!";
  private PrintStream outStream;

  public MainView(PrintStream outStream) {
    this.outStream = outStream;
  }

  public void displayWelcomeMessage() {
    outStream.println(this.GREETING);
  }

}
