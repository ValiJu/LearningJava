package com.example.LearningJava.DesignPatterns.StructuralDp.Composite;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
@Data
@Getter
@Setter
public class CompositeTest {
  @Test
  public void compositeTest(){
    Department salesDepartment = new SalesDepartment(
        1, "Sales department");
    Department financialDepartment = new FinancialDepartment(
        2, "Financial department");

    HeadDepartment headDepartment = new HeadDepartment(
        3, "Head department");

    BiggerHeadDepartment biggerHeadDepartment = new BiggerHeadDepartment(4,"Bigger Head Department");

    headDepartment.addDepartment(salesDepartment);
    headDepartment.addDepartment(financialDepartment);
    biggerHeadDepartment.addDepartment(headDepartment);

    biggerHeadDepartment.printDepartmentName();
  }
}
