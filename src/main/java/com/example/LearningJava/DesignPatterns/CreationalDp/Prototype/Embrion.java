package com.example.LearningJava.DesignPatterns.CreationalDp.Prototype;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Embrion {

  private String name;
  private int days;

  public Embrion() {

  }

  public Embrion(Embrion embrion) {
    this.name = embrion.getName();
    this.days = embrion.getDays();

  }

  public Embrion clone() {
    return new Embrion(this);
  }

}
