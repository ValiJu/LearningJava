package com.example.LearningJava.DesignPatterns.StructuralDp.Proxy;

import org.junit.Test;

public class TestProxy {
  @Test
  public void testProxy(){
    ExpensiveObject ob1 = new ExpensiveObjectProxy();
    ob1.process();
    ob1.process();

  }

}
