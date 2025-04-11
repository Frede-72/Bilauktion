package Exceptions;

public class NoCarsException extends RuntimeException {
  public NoCarsException(String message) {
    super(message);
  }
}
