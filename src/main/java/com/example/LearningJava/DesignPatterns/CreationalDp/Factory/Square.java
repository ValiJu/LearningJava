package com.example.LearningJava.DesignPatterns.CreationalDp.Factory;

import java.awt.Shape;

public class Square implements Poligon {
  private int numberOfSides = 4;
  @Override
  public int getNumberOfSides() {
    return numberOfSides;
  }
}
