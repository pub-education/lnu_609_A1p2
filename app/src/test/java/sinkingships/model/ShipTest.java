package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShipTest {
  
  @Test
  public void shouldGetTheNameOfTheShipTypeCarrier() {
    Ship sut = new Ship(ShipType.CARRIER);
    assertEquals("Carrier", sut.getShipType());
  } 

  @Test
  public void shouldGetTheNameOfTheShipTypeBattleship() {
    Ship sut = new Ship(ShipType.BATTLESHIP);
    assertEquals("Battleship", sut.getShipType());
  } 
}
