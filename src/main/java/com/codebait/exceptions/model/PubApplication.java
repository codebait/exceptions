package com.codebait.exceptions.model;

public class PubApplication {

  public static void main(String[] args) {

    String streetName = PubCreator.create().getOwner().getAddress().getStreet().toUpperCase();
    System.out.println(streetName);
  }
}
