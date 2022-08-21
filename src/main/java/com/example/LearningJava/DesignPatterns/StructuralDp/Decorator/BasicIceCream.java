package com.example.LearningJava.DesignPatterns.StructuralDp.Decorator;

public class BasicIceCream implements IceCream {

  @Override
  public String getToppings() {
    return "vanilla ";
  }
}
