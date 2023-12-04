package sinkingships.model;

/**
 * Point class.
 */
public class Point {
  private int horizontalPosition;
  private char verticalPosition;

  public Point(int horizontalPosition, char verticalPosition) {
    this.verticalPosition = setYpositionLowerCase(verticalPosition);
    this.horizontalPosition = horizontalPosition;
  }

  private char setYpositionLowerCase(char yPosition) {
    return Character.toLowerCase(yPosition);
  }

  public char getVerticalPosition() {
    return this.verticalPosition;
  }

  public int getVerticalIndex() {
    // Create zero index for char values.
    return this.verticalPosition - 'a';
  }

  public int getHorizontalPosition() {
    return this.horizontalPosition;
  }
  
}
