package com.example.LearningJava.DesignPatterns.StructuralDp.Composite;

import java.util.ArrayList;
import java.util.List;

public class BiggerHeadDepartment implements Department {
  private Integer id;
  private String name;

  List<Department> childDepartments;

  public BiggerHeadDepartment(Integer id, String name) {
    this.id = id;
    this.name = name;
    this.childDepartments = new ArrayList<>();
  }

  public void addDepartment(Department department) {
    childDepartments.add(department);
  }

  @Override
  public void printDepartmentName() {
    System.out.println(getClass().getSimpleName());
    childDepartments.forEach(Department::printDepartmentName);
  }
  public void removeDepartment(Department department) {
    childDepartments.remove(department);
  }
}
