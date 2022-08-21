package com.example.LearningJava.DesignPatterns.CreationalDp.AbstractFactory;

public class RoundedRectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Inside RoundedRectangle::draw() method.");
  }
}
