package com.codebait.exceptions.performance;

import com.codebait.exceptions.NormalException;
import com.codebait.exceptions.StackDisabledException;
import java.io.IOException;


public class ExceptionService {

  void throwNormalException() {
    throw new NormalException("buu");
  }


  void throwExceptionWithoutStack() {
    throw new StackDisabledException("buu");
  }


  void throwIOException() throws IOException {
    throw new IOException("File not found!");
  }


  void throwIOExceptionOverrideByRuntimeException() {
    try {
      throwIOException();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  void throwIOExceptionOverrideByExceptionWithoutStack() {
    try {
      throwIOException();
    } catch (IOException e) {
      throw new StackDisabledException("IO failed", e);
    }
  }


  void throwIOExceptionOverrideWithSneakyThrow() {
    try {
      throwIOException();
    } catch (IOException e) {
      sneakyThrow(e);
    }
  }


  <T extends Throwable> void sneakyThrow(Exception e) throws T {
    throw (T) e;
  }

}
