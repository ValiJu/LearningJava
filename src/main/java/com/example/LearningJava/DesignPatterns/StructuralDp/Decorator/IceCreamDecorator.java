package com.example.LearningJava.DesignPatterns.StructuralDp.Decorator;

public class IceCreamDecorator implements IceCream {

  private IceCream iceCream;

  public IceCreamDecorator(IceCream iceCream) {
    this.iceCream = iceCream;
  }

  @Override
  public String getToppings() {
    return iceCream.getToppings();
  }
}
