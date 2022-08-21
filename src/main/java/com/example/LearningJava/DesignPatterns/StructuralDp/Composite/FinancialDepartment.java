package com.example.LearningJava.DesignPatterns.StructuralDp.Composite;

public class FinancialDepartment implements Department {

  private Integer id;
  private String name;

  public void printDepartmentName() {
    System.out.print(getClass().getSimpleName()+" ");
  }

  public FinancialDepartment(Integer id, String name) {
    this.id = id;
    this.name = name;
  }
}
