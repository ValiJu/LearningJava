package com.example.LearningJava.DesignPatterns.StructuralDp.Proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExpensiveObjectImpl implements ExpensiveObject {

  public ExpensiveObjectImpl(){
    initialConfiguration();
  }
  @Override
  public void process() {
    log.info("processing...");
  }

  public void initialConfiguration(){
    log.info("long initial configuration...");
  }
}
