package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class BoardTest {
  
  @Test
  public void boardExists() {
    Board board = new Board();
    assertNotNull(board, "board should be a class");
  }
}
