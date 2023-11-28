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
  public void shouldReturnHorizontalValueBLowerCase() {
    Point sut = new Point('B', 2);
    assertEquals('b', sut.getHorizontalPosition());
  }
}
