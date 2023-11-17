package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import sinkingships.model.HumanPlayer;

/**
 * Unit test for the Board class.
 */
public class ModelPlayerTest {
  
  @Test
  void modelPlayerClassExists() {
    ModelPlayer classUnderTest = new HumanPlayer("Joe!");
    assertNotNull(classUnderTest, "Class should exist!");
  }
}
