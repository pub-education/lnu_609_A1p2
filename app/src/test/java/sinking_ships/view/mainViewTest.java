package sinking_ships.view;

import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class mainViewTest {

  @Test
  public void mainViewExists() {
    PrintStream printstream = mock(PrintStream.class);
    InputStream inputStream = mock(InputStream.class);
    MainView mainView = new MainView(printstream, inputStream);
    assertNotNull(mainView, "mainView should be a class");
  }

  @Test
  public void mainViewShouldBeAbleToDisplayMessage() {
    PrintStream printstream = mock(PrintStream.class);
    InputStream inputStream = mock(InputStream.class);
    MainView mainView = new MainView(printstream, inputStream);
    String message = "Hello World!";
    String expected = message;
    mainView.displayMessage(message);
    verify(printstream, atLeastOnce()).println(expected);
  }

  // view should have a method to display a welcome message

  // view should have a method to display the board
  
  // view should have a method to display clear the screen

  // view should have a method to press enter to continue

  // view should have a method to collect user input

  // view should have a method to display a message


}
