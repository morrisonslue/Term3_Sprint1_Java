package com.pharmasys.models;

public class Person {
    private String id;
    private String name;
    private int age;
    private String phoneNumber;

    // constructor
    public Person() {
        this.id = "N/A";
        this.name = "Unknown";
        this.age = 0;
        this.phoneNumber = "N/A";
    }

    public Person(String id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // getters setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString method
    public String toString() {
        return "Person: " + name + " | Age: " + age + " | ID: " + id + " | Phone: " + phoneNumber;
    }
}
