package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RotationTest {
  Rotation sut;

  @Test
  public void testEnumComparisonNorth() {
    sut = Rotation.NORTH;
    
    assertTrue(sut == Rotation.NORTH);
  }
}
