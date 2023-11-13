package sinking_ships.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sinking_ships.view.MainView;

public class mainViewTest {
  @Test
  public void mainViewExists() {
    MainView mainView = new MainView();
    assertNotNull(mainView, "mainView should be a class");
  }
}
