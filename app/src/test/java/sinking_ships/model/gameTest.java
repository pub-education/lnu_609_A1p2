package sinking_ships.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class gameTest {
  @Test
  public void gameExists() {
    Game game = new Game();
    assertNotNull(game, "game should be a class");
  }
}
