package com.example.LearningJava.PizzaShop;

import com.example.LearningJava.PizzaShop.PizzaTypes.PizzaType;
import lombok.Data;

import java.util.List;

@Data
public class Command {
    private Client client;
    private PizzaType pizzaType;
    private List<String> toppings;
}
