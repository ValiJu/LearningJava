package com.example.LearningJava.DesignPatterns.CreationalDp.AbstractFactory;

public class Square implements Shape{

  @Override
  public void draw() {
    System.out.println("Inside Square::draw() method.");
  }
}
