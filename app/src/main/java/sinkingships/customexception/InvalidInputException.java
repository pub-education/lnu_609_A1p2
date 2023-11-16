package sinkingships.customexception;

public class InvalidInputException extends Exception {
  public InvalidInputException(String allowed) {
    super("message: Invalid input. Allowed: " + allowed + ".");
  }
}
