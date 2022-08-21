package com.example.LearningJava.DesignPatterns.StructuralDp.Decorator;

public class NugaIceCream extends IceCreamDecorator {

  public NugaIceCream(IceCream iceCream) {
    super(iceCream);
  }

  @Override
  public String getToppings() {
    return super.getToppings() + "nuga ";
  }
}
