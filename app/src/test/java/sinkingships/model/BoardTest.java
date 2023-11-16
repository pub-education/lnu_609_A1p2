package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Board class.
 */
public class BoardTest {
  
      @Test
    void boardExists() {
        Board classUnderTest = new Board();
        assertNotNull(classUnderTest, "Class should exist!");
    }
}
