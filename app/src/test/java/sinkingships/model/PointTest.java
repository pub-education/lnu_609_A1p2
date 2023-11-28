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
  public void shouldReturnHorizontalValueAllLowerCaseLetters() {
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
  public void shouldReturnHorizontalValueLowerCaseForAllUpperCase() {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    try {
      for (int i = 0; i < alphabet.length; i++) {
        Point sut = new Point(alphabet[i], 2);
        assertEquals(alphabetLower[i], sut.getHorizontalPosition());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }

  @Test
  public void shouldReturnHorizontalValueIndex() {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    try {
      for (int i = 0; i < alphabet.length; i++) {
        Point sut = new Point(alphabet[i], 2);
        assertEquals(i, sut.getHorizontalIndex());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }

  @Test
  public void shouldReturnHorizontalValueIndexUppercase() {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    try {
      for (int i = 0; i < alphabet.length; i++) {
        Point sut = new Point(alphabet[i], 2);
        assertEquals(i, sut.getHorizontalIndex());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }

  @Test 
  public void shouldReturnVerticalValue() {
    Point sut = new Point('a', 2);
    assertEquals(2, sut.getVerticalPosition());
  }
}
