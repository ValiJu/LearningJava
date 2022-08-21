package com.example.LearningJava.DesignPatterns.StructuralDp.Decorator;

public class MilkIceCream extends IceCreamDecorator {

  public MilkIceCream(IceCream iceCream) {
    super(iceCream);
  }

  @Override
  public String getToppings() {
    return super.getToppings() + "milk ";
  }
}
