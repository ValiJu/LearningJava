package com.example.LearningJava.DesignPatterns.StructuralDp.Bridge;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
@Slf4j
public class TestBridge {
  @Test
  public void testBridge(){
    Device tv = new Tv();
    Device radio = new Radio();

    Remote basicRemote = new BasicRemote(tv);
    Remote advancedRemote = new AdvancedRemote(radio);

    log.info(basicRemote.toString());
    log.info(advancedRemote.toString());



  }

}
