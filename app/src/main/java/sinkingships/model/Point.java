package sinkingships.model;

public class Point {
  private char xPosition;
  private int yPosition;

  public Point(char xPosition, int yPosition) {
    this.xPosition = setXPositionLowerCase(xPosition);
    this.yPosition = yPosition;
  }

  private char setXPositionLowerCase(char xPosition) {
    return Character.toLowerCase(xPosition);
  }

  public Object getHorizontalPosition() {
    return this.xPosition;
  }

  public Integer getHorizontalIndex() {
    // Create zero index for char values.
    return this.xPosition - 'a';
  }

  public Integer getVerticalPosition() {
    return this.yPosition;
  }
  
}
