package sinkingships.model;

import org.junit.jupiter.api.Test;

public class RotationTest {
  Rotation sut;

  @Test
  public void testEnumComparison() {
    sut = Rotation.NORTH;
    
    Assert::assertTrue(sut == Rotation.NORTH);
  }
}
