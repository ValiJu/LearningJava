package com.example.LearningJava.PizzaShop;

import com.example.LearningJava.PizzaShop.PizzaTypes.PizzaFactory;
import com.example.LearningJava.PizzaShop.PizzaTypes.PizzaType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    String name;
    PizzaFactory pizzaFactory;

    public void checkPizza(PizzaType pizzaType, String name){
      if(this.name.equals(name)){
          System.out.println("My name is "+name+" and I took the pizza "+ pizzaType.toString());
      }
    }
}
