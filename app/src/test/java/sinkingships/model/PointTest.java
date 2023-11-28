package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Point class.
 */
public class PointTest {
  
  @Test
  public void shouldReturnHorizontalValue() {
    Point sut = new Point('a', 2);
    assertEquals('a', sut.getHorizontalPosition());
  }
}
