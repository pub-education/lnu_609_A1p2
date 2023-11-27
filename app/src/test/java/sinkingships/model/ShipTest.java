package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShipTest {

  @Test
    void testShipTypeAndSize() {
        // Test with each ShipType enum
        for (ShipType type : ShipType.values()) {
            Ship ship = new Ship(type);
            assertEquals(type.getName(), ship.getShipType());
            assertEquals(type.getSize(), ship.getShipSize());
        }
    }
}
