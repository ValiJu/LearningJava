package com.example.LearningJava.DesignPatterns.StructuralDp.Proxy;

public class ExpensiveObjectProxy implements ExpensiveObject {

  private ExpensiveObject expensiveObject;

  @Override
  public void process() {
    if (this.expensiveObject == null) {
      this.expensiveObject = new ExpensiveObjectImpl();
    }
    expensiveObject.process();

  }
}
