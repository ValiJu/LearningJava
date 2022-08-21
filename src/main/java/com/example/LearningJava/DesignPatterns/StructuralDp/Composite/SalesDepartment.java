package com.example.LearningJava.DesignPatterns.StructuralDp.Composite;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SalesDepartment implements Department {

  private Integer id;
  private String name;

  public SalesDepartment(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public void printDepartmentName() {
    System.out.print(getClass().getSimpleName()+" ");
  }

}
