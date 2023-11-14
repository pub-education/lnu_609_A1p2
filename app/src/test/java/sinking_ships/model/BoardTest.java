package sinking_ships.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import sinking_ships.model.Board;

public class BoardTest {
  
      @Test
    void boardExists() {
        Board classUnderTest = new Board();
        assertNotNull(classUnderTest, "Class should exist!");
    }
}
