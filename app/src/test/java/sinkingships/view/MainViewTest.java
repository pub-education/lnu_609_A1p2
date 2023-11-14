package sinkingships.view;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the MainView class.
 */
public class MainViewTest {
  @Test
  public void mainViewExists() {
    MainView mainView = new MainView();
    assertNotNull(mainView, "mainView should be a class");
  }  
}
