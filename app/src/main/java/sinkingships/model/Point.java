package sinkingships.model;

public class Point {
  private char xPosition;

  public Point(char xPosition, int i) {
    this.xPosition = setXPositionLowerCase(xPosition);
  }

  private char setXPositionLowerCase(char xPosition) {
    return Character.toLowerCase(xPosition);
  }

  public Object getHorizontalPosition() {
    return this.xPosition;
  }

  public Integer getHorizontalIndex() {
    return null;
  }
  
}
