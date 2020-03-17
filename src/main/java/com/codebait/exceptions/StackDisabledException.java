package com.codebait.exceptions;


public class StackDisabledException extends RuntimeException {

  public StackDisabledException(String message) {
    super(message, null, true, false);
  }

  public StackDisabledException(String message, Exception e) {
    super(message, e, true, false);
  }
}
