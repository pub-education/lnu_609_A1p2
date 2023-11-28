package sinkingships.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    try {
      for (int i = 0; i < alphabet.length; i++) {
        Point sut = new Point(alphabet[i], 2);
        assertEquals(alphabet[i], sut.getHorizontalPosition());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }

  @Test
  public void shouldReturnHorizontalValueIndexUppercase() {

    Point sut = new Point('E', 2);
    assertEquals(4, sut.getHorizontalIndex());
  }
}
