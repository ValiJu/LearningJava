package com.example.LearningJava.DesignPatterns.CreationalDp.Factory;

import java.awt.Point;

public class Triangle implements Poligon {
    private int numberOfSides = 4;

  @Override
  public int getNumberOfSides() {
    return numberOfSides;
  }
}
