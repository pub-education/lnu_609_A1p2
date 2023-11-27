package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShipTest {
  
  @Test
  public void shouldGetTheNameOfTheShipType() {
    ShipType shipType = ShipType.CARRIER;
    Ship sut = new Ship(shipType);
    assertEquals(shipType.getName(), sut.getShipType());
  }

  
}
