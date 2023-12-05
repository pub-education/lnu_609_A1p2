package sinkingships.view;

import java.io.PrintStream;

public class WelcomeView {

  private PrintStream outStream;

  public WelcomeView(PrintStream outStream) {
    this.outStream = outStream;
  }

  protected void displayWelcomeMessage() {
    outStream.println("Welcome to Sinking Ships!");
  }
  
}
