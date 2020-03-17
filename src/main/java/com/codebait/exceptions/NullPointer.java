package com.codebait.exceptions;

class NullPointer {

  public static void main(String[] args) {
    for (int i = 0; i < 200_000; i++) {
      try {
        ((Object) null).getClass();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
