package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Ship class.
 */
public class ShipTypeTest {

  @Test
    public void shouldGetTheNameOfTheShipTypeCarrier() {
        assertEquals("Carrier", ShipType.CARRIER.getName());
        
    }
}
