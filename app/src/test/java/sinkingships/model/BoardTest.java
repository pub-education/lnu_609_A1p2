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

  @Test
  public void shouldHaveTheCorrectShipsAfterCreation() {
    Board sut = new Board();
    assertEquals(ShipType.CARRIER, sut.getShips().get(0));
    assertEquals(ShipType.BATTLESHIP, sut.getShips().get(1));
    assertEquals(ShipType.CRUISER, sut.getShips().get(2));
    assertEquals(ShipType.SUBMARINE, sut.getShips().get(3));
    assertEquals(ShipType.DESTROYER, sut.getShips().get(4));
  }

}
