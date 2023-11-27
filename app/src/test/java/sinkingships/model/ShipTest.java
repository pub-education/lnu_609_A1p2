package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShipTest {
  
  @Test
  public void shouldGetTheNameOfTHeShipType() {
    Ship sut = new Ship(ShipType.CARRIER);
    assertEquals("Carrier", sut.getShipType());
  } 
}
