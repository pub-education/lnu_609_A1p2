package sinkingships.view;

import java.io.PrintStream;

public class WelcomeView {

  public static final String GREETING = "Welcome to Sinking Ships!";
  private PrintStream outStream;

  public WelcomeView(PrintStream outStream) {
    this.outStream = outStream;
  }

  protected void displayWelcomeMessage() {
    outStream.println(this.GREETING);
  }
  
}
