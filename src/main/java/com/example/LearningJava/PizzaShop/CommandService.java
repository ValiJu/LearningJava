package com.example.LearningJava.PizzaShop;

import com.example.LearningJava.PizzaShop.PizzaTypes.Pizza;
import com.example.LearningJava.PizzaShop.PizzaTypes.PizzaFactory;
import org.springframework.stereotype.Component;

@Component
public class CommandService {
    PizzaFactory pizzaFactory = new PizzaFactory();

    public Pizza processCommand(Command command) throws InterruptedException {
        return pizzaFactory.getPizza(command);
    }
}
