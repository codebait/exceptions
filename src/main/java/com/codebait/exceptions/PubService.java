package com.codebait.exceptions;

import java.time.Clock;
import java.time.LocalTime;

class PubService implements AutoCloseable {

  private final Clock clock;
  private int customers = 0;

  public PubService(Clock clock) {

    this.clock = clock;
  }

  public void customerEntry() {
    customers++;
  }

  public void customerLeaving() {
    if (customers == 0) {
      throw new NormalException("There are no customer in pub");
    }
    customers--;
  }

  @Override
  public void close() throws Exception {
    if (customers != 0) {
      throw new NormalException("Can't close pub!!!");
    }
    if (LocalTime.now(clock).isBefore(LocalTime.of(23, 59, 59))) {
      throw new NormalException("To early for closing");
    }
  }
}
