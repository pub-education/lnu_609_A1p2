package sinking_ships.view;

import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

  // view should have a method to display a welcome message

  // view should have a method to display the board
  
  // view should have a method to display clear the screen

  // view should have a method to press enter to continue

  // view should have a method to collect user input

  // view should have a method to display a message


}
