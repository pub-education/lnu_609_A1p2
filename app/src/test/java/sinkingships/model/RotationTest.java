package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests for the Rotation enum.
 */
public class RotationTest {
  Rotation sut;

  @Test
  public void testEnumComparisonNorth() {
    sut = Rotation.NORTH;
    
    assertTrue(sut == Rotation.NORTH);
    assertTrue("North".equals(sut.toString()));
  }

  @Test
  public void testEnumComparisonWest() {
    sut = Rotation.WEST;
    
    assertTrue(sut == Rotation.WEST);
  }

  @Test
  public void testEnumComparisonSouth() {
    sut = Rotation.SOUTH;
    
    assertTrue(sut == Rotation.SOUTH);
  }

  @Test
  public void testEnumComparisonEast() {
    sut = Rotation.EAST;
    
    assertTrue(sut == Rotation.EAST);
  }

  @Test
  public void testEnumComparisonNone() {
    sut = Rotation.NONE;
    
    assertTrue(sut == Rotation.NONE);
  }
}
