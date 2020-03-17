package com.codebait.exceptions.performance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codebait.exceptions.NormalException;
import com.codebait.exceptions.StackDisabledException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ExceptionServiceTest {

  private ExceptionService exceptionService = new ExceptionService();

  @Test
  void shouldThrowNormalException() {
    NormalException exception = assertThrows(NormalException.class,
        () -> exceptionService.throwNormalException());

    assertEquals("buu", exception.getMessage());
    assertNotEquals(0, exception.getStackTrace().length);

    exception.printStackTrace();
  }


  @Test
  void shouldThrowExceptionWithoutStack() {
    StackDisabledException exception = assertThrows(StackDisabledException.class,
        () -> exceptionService.throwExceptionWithoutStack());

    assertEquals("buu", exception.getMessage());
    assertEquals(0, exception.getStackTrace().length);
    exception.printStackTrace();

  }


  @Test
  void shouldThrowIOException() throws IOException {
    IOException exception = assertThrows(IOException.class,
        () -> exceptionService.throwIOException());

    assertEquals("File not found!", exception.getMessage());
    assertNotEquals(0, exception.getStackTrace().length);
    exception.printStackTrace();
  }


  @Test
  void shouldThrowIOExceptionOverrideByRuntimeException() {
    RuntimeException exception = assertThrows(RuntimeException.class,
        () -> exceptionService.throwIOExceptionOverrideByRuntimeException());

    assertEquals("java.io.IOException: File not found!", exception.getMessage());
    assertNotEquals(0, exception.getStackTrace().length);
    assertEquals(IOException.class, exception.getCause().getClass());
    assertEquals("File not found!", exception.getCause().getMessage());
    exception.printStackTrace();
  }


  @Test
  void shouldThrowIOExceptionOverrideByExceptionWithoutStack() {
    StackDisabledException exception = assertThrows(StackDisabledException.class,
        () -> exceptionService.throwIOExceptionOverrideByExceptionWithoutStack());

    assertEquals("IO failed", exception.getMessage());
    assertEquals(0, exception.getStackTrace().length);
    assertEquals(IOException.class, exception.getCause().getClass());
    assertEquals("File not found!", exception.getCause().getMessage());
    exception.printStackTrace();
  }


  @Test
  void shouldThrowIOExceptionOverrideWithSneakyThrow() {
    IOException exception = assertThrows(IOException.class,
        () -> exceptionService.throwIOExceptionOverrideWithSneakyThrow());

    assertEquals("File not found!", exception.getMessage());
    assertNotEquals(0, exception.getStackTrace().length);
    exception.printStackTrace();
  }
}
