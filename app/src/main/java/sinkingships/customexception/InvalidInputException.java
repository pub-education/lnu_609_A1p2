package sinkingships.customexception;

/**
 * Exception thrown when a rotation is invalid.
 */
public class InvalidInputException extends Exception {
  public InvalidInputException(String allowed) {
    super("message: Invalid input. Allowed: " + allowed + ".");
  }
}
