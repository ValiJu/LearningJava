package com.example.LearningJava.DesignPatterns.CreationalDp.Factory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class FactoryTest {
  @Test
  public void factoryTest(){
    PoligonFactory factory = new PoligonFactory();
    Poligon shape = factory.getPoligon(3);
    Poligon shape1 = factory.getPoligon(4);
    log.info(shape.getClass().getSimpleName()+" si "+shape1.getClass().getSimpleName());
  }
}
