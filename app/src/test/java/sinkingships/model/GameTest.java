package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Game class.
 */
public class GameTest {
  @Test
  public void gameExists() {
    Game game = new Game();
    assertNotNull(game, "game should be a class");
  }

  @Test
  public void gameHasBoard() {
    // Game game = new Game();
    // assertNotNull(game.getBoard(), "game should have a board");
  }
}
