package com.codebait.exceptions.model;

public class PubCreator {

  public static Pub create() {
    return new Pub(new Person(null));
  }

  public static class Person {

    public Person(Address address) {
      this.address = address;
    }

    private Address address;

    public Address getAddress() {
      return address;
    }
  }

  public static class Pub {

    private Person owner;

    public Pub(Person owner) {
      this.owner = owner;
    }

    public Person getOwner() {
      return owner;
    }
  }

  public static class Address {

    private String street;

    public Address(String street) {
      this.street = street;
    }

    public String getStreet() {
      return street;
    }
  }

}
