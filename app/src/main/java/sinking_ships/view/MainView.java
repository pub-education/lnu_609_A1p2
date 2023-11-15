package sinking_ships.view;

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
}
