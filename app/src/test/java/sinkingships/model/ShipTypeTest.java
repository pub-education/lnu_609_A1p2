package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Ship class.
 */
public class ShipTypeTest {

  @Test
  public void shouldGetTheNameOfTheShipType() {
    assertEquals("Carrier", ShipType.CARRIER.getName());
    assertEquals("Battleship", ShipType.BATTLESHIP.getName());
    assertEquals("Cruiser", ShipType.CRUISER.getName());
    assertEquals("Submarine", ShipType.SUBMARINE.getName());
    assertEquals("Destroyer", ShipType.DESTROYER.getName());
  }

  @Test
  public void shouldGetTheSizeOfTheShipType() {
    assertEquals(5, ShipType.CARRIER.getSize());
    assertEquals(4, ShipType.BATTLESHIP.getSize());
    assertEquals(3, ShipType.CRUISER.getSize());
    assertEquals(3, ShipType.SUBMARINE.getSize());
    assertEquals(2, ShipType.DESTROYER.getSize());
  }
}
