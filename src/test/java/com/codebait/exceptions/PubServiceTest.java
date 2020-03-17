package com.codebait.exceptions;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;

class PubServiceTest {

  Clock clock = Clock.fixed(Instant.parse("2018-08-22T10:00:00Z"), ZoneOffset.UTC);

  @Test
  void test1() throws Exception {
    PubService pubService = new PubService(clock);
    pubService.customerEntry();
    pubService.close();
  }


  @Test
  void test2() throws Exception {
    try (PubService pubService = new PubService(clock)) {
      pubService.customerEntry();
    }
  }


  @Test
  void test3() throws Exception {
    PubService pubService = new PubService(clock);
    pubService.customerEntry();
    pubService.customerLeaving();
    pubService.customerLeaving();
    pubService.close();
  }


  @Test
  void test4() throws Exception {
    try (PubService pubService = new PubService(clock)) {
      pubService.customerEntry();
      pubService.customerLeaving();
      pubService.customerLeaving();
    }
  }


  @Test
  void test5() throws Exception {
    PubService pubService = new PubService(clock);
    try {
      pubService.customerEntry();
      pubService.customerLeaving();
      pubService.customerLeaving();
    } finally {
      pubService.close();
    }
  }


  @Test
  void test6() throws Exception {
    PubService pubService = new PubService(clock);
    Exception exception = null;
    try {
      pubService.customerEntry();
      pubService.customerLeaving();
      pubService.customerLeaving();
    } catch (Exception e) {
      exception = e;
    } finally {
      try {
        pubService.close();
      } catch (Exception e) {
        if (exception != null) {
          exception.addSuppressed(e);
          throw exception;
        }
      }
    }

  }

}
