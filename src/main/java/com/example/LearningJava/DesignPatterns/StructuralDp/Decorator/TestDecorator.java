package com.example.LearningJava.DesignPatterns.StructuralDp.Decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestDecorator {

  @Test
  public void testDecorator() {
    IceCream i1 = new BasicIceCream();
    log.info(i1.getToppings());
    i1 = new IceCreamDecorator(new MilkIceCream(i1));
    log.info(i1.getToppings());
    i1 = new IceCreamDecorator(new NugaIceCream(i1));
    log.info(i1.getToppings());
    i1 = new IceCreamDecorator(new NugaIceCream(i1));
    log.info(i1.getToppings());


  }

}
