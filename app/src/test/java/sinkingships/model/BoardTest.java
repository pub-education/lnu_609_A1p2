package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class BoardTest {

  @Test
  public void boardExists() {
    Board classUnderTest = new Board();
    assertNotNull(classUnderTest, "Class should exist!");
  }
}
