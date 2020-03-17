package com.codebait.exceptions;

public class SuppressionDisabledException extends RuntimeException {

  public SuppressionDisabledException(String message) {
    super(message, null, false, true);
  }
}
