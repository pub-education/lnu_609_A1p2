package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Tests for the Player class.
 */
public class PlayerTest {

  @Test
  void playerExists() {
    Player sut = new Player();
    assertNotNull(sut, "Class should exist!");
  }
}
