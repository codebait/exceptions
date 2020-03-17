package com.codebait.exceptions.performance;

import java.io.IOException;
import org.openjdk.jmh.runner.RunnerException;

class JMHTestRunner {

  public static void main(String[] args) throws IOException, RunnerException {
    org.openjdk.jmh.Main.main(args);

  }
}
