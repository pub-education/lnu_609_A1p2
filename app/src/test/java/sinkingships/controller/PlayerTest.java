package sinkingships.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Player class.
 */
public class PlayerTest {
  @Test
  void playerExists() {
    Player sut = new Player();
    assertNotNull(sut, "Player should be a class");
  }
}
