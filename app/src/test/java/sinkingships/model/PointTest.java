package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Point class.
 */
public class PointTest {
  
  @Test
  public void shouldReturnHorizontalValueA() {
    Point sut = new Point('a', 2);
    assertEquals('a', sut.getHorizontalPosition());
  }

  @Test
  public void shouldReturnHorizontalValueB() {
    Point sut = new Point('b', 2);
    assertEquals('b', sut.getHorizontalPosition());
  }

  @Test
  public void shouldReturnHorizontalValueLowerCase() {
    Point sut = new Point('F', 2);
    assertEquals('f', sut.getHorizontalPosition());
  }

  @Test
  public void shouldReturnHorizontalValueIndex() {
    Point sut = new Point('a', 2);
    assertEquals(0, sut.getHorizontalIndex());
  }
}
