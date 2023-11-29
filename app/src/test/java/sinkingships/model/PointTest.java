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
    Point sut = new Point(2, 'a');
    assertEquals(2, sut.getHorizontalPosition());
  }

  @Test
  public void shouldReturnVerticalValueAllLowerCaseLetters() {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    try {
      for (int i = 0; i < alphabet.length; i++) {
        Point sut = new Point(2, alphabet[i]);
        assertEquals(alphabet[i], sut.getVerticalPosition());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }

  @Test
  public void shouldReturnVerticalValueLowerCaseForAllUpperCaseEntries() {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    try {
      for (int i = 0; i < alphabet.length; i++) {
        Point sut = new Point(2, alphabet[i]);
        assertEquals(alphabetLower[i], sut.getVerticalPosition());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }

  @Test
  public void shouldReturnVerticalValueIndex() {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    try {
      for (int i = 0; i < alphabet.length; i++) {
        Point sut = new Point(2, alphabet[i]);
        assertEquals(i, sut.getVerticalIndex());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }

  @Test
  public void shouldReturnVerticalValueIndexUppercase() {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    try {
      for (int i = 0; i < alphabet.length; i++) {
        Point sut = new Point(2, alphabet[i]);
        assertEquals(i, sut.getVerticalIndex());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }

  @Test 
  public void shouldReturnHorizontalValue() {
    int[] numbers = {0, 1, 2, 3, 4, 5, 7, 9, 11, 17, 23, 101};

    try {
      for (int i = 0; i < numbers.length; i++) {
        Point sut = new Point(numbers[i], 'a');
        assertEquals(numbers[i], sut.getHorizontalPosition());
      }
    } catch (Exception e) {
      System.out.println(e);
      assertFalse(true);
    }
  }
}
