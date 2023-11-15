package sinking_ships.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class mainViewTest {
  @Test
  public void mainViewExists() {
    MainView mainView = new MainView();
    assertNotNull(mainView, "mainView should be a class");
  }

  @Test
  public void mainViewShouldBeAbleToDisplayMessage() {
    MainView mainView = new MainView();
    String message = "Hello World!";
    String expected = message;
    String actual = mainView.displayMessage(message);
    assertEquals(expected, actual);
  }

  // view should have a method to display a welcome message

  // view should have a method to display the board
  
  // view should have a method to display clear the screen

  // view should have a method to press enter to continue

  // view should have a method to collect user input

  // view should have a method to display a message


}
