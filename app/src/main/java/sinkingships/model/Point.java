package sinkingships.model;

public class Point {
  private int xPosition;
  private char yPosition;

  public Point(int xPosition, char yPosition) {
    this.yPosition = setYPositionLowerCase(yPosition);
    this.xPosition = xPosition;
  }

  private char setYPositionLowerCase(char yPosition) {
    return Character.toLowerCase(yPosition);
  }

  public Object getVerticalPosition() {
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
