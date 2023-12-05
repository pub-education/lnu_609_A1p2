package sinkingships.view;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class WelcomeViewTest {

  @Test
  void displayWelcomeMessageOutputGreeting() {
    PrintStream outStreamMock = mock(PrintStream.class);

    var sut = new WelcomeView(outStreamMock);
    sut.displayWelcomeMessage();

    verify(outStreamMock).println(sut.GREETING);
  }
}
