package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for the Board class.
 */
public class BoardTest {

  @Test
  public void shouldHaveFiveShipsAfterCreation() {
    Board sut = new Board();
    assertEquals(5, sut.getShips().size());
  }
}
