package com.codebait.exceptions.performance;

import java.io.IOException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

public class PerformanceExceptionTest {

  public static ExceptionService exceptionService = new ExceptionService();


  @Benchmark
  @Fork(1)
  @BenchmarkMode(Mode.Throughput)
  @Warmup(iterations = 5)
  public void shouldThrowNormalException() {
    try {
      exceptionService.throwNormalException();
    } catch (Exception ignore) {
    }
  }

  @Benchmark
  @Fork(1)
  @BenchmarkMode(Mode.Throughput)
  @Warmup(iterations = 5)
  public void shouldThrowExceptionWithoutStack() {
    try {
      exceptionService.throwExceptionWithoutStack();
    } catch (Exception ignore) {
    }

  }

  @Benchmark
  @Fork(1)
  @BenchmarkMode(Mode.Throughput)
  @Warmup(iterations = 5)
  public void shouldThrowIOException() throws IOException {
    try {
      exceptionService.throwIOException();
    } catch (Exception ignore) {
    }
  }

  @Benchmark
  @Fork(1)
  @BenchmarkMode(Mode.Throughput)
  @Warmup(iterations = 5)
  public void shouldThrowIOExceptionOverrideByRuntimeException() {
    try {
      exceptionService.throwIOExceptionOverrideByRuntimeException();
    } catch (Exception ignore) {
    }
  }

  @Benchmark
  @Fork(1)
  @BenchmarkMode(Mode.Throughput)
  @Warmup(iterations = 5)
  public void shouldThrowIOExceptionOverrideByExceptionWithoutStack() {
    try {
      exceptionService.throwIOExceptionOverrideByExceptionWithoutStack();
    } catch (Exception ignore) {
    }
  }

  @Benchmark
  @Fork(1)
  @BenchmarkMode(Mode.Throughput)
  @Warmup(iterations = 5)
  public void shouldThrowIOExceptionOverrideWithSneakyThrow() {
    try {
      exceptionService.throwIOExceptionOverrideWithSneakyThrow();
    } catch (Exception ignore) {
    }
  }



/*
  Benchmark                                                                        Mode  Cnt          Score          Error  Units
  PerformanceExceptionTest.shouldThrowExceptionWithoutStack                       thrpt    5  135316795.840 ± 20069811.781  ops/s
  PerformanceExceptionTest.shouldThrowIOException                                 thrpt    5     868566.948 ±   110246.591  ops/s
  PerformanceExceptionTest.shouldThrowIOExceptionOverrideByExceptionWithoutStack  thrpt    5     851079.096 ±   146095.045  ops/s
  PerformanceExceptionTest.shouldThrowIOExceptionOverrideByRuntimeException       thrpt    5     424635.940 ±    76660.201  ops/s
  PerformanceExceptionTest.shouldThrowIOExceptionOverrideWithSneakyThrow          thrpt    5     857989.556 ±   138374.562  ops/s
  PerformanceExceptionTest.shouldThrowNormalException                             thrpt    5     869185.321 ±    97115.606  ops/s
  */
}
