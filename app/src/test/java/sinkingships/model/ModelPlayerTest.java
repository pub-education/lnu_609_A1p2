package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Board class.
 */
public class ModelPlayerTest {
  
  @Test
  void modelPlayerClassExists() {
    Player classUnderTest = new Computer("Joe!");
    assertNotNull(classUnderTest, "Class should exist!");
  }
}
