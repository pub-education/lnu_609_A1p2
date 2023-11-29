package sinkingships.model;

/**
 * Point class.
 */
public class Point {
  private int xPosition;
  private char yPosition;

  public Point(int xPosition, char yPosition) {
    this.yPosition = setYpositionLowerCase(yPosition);
    this.xPosition = xPosition;
  }

  private char setYpositionLowerCase(char yPosition) {
    return Character.toLowerCase(yPosition);
  }

  public char getVerticalPosition() {
    return this.yPosition;
  }

  public int getVerticalIndex() {
    // Create zero index for char values.
    return this.yPosition - 'a';
  }

  public int getHorizontalPosition() {
    return this.xPosition;
  }
  
}
