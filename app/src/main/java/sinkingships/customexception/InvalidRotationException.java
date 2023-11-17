package sinkingships.customexception;

/**
 * Exception thrown when a rotation is invalid.
 */
public class InvalidRotationException extends Exception {
  public InvalidRotationException(String message) {
    super(message);
  }
}
