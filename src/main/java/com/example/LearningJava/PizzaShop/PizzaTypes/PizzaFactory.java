package com.example.LearningJava.PizzaShop.PizzaTypes;

import com.example.LearningJava.PizzaShop.Client;
import com.example.LearningJava.PizzaShop.Command;
import com.example.LearningJava.PizzaShop.PizzaDecorator.PizzaDecorator;
import com.example.LearningJava.PizzaShop.PizzaDecorator.ToppingFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PizzaFactory {
    private static PizzaFactory pizzaFactory;
    private static final ToppingFactory toppingFactory = new ToppingFactory();
    List<Client> clients = new ArrayList<>();

    public PizzaFactory() {

    }

    public static PizzaFactory getInstance() {
        return Objects.requireNonNullElseGet(pizzaFactory, PizzaFactory::new);
    }

    public Pizza getPizza(Command command) throws InterruptedException {
        addClient(command.getClient());
        preparePizza(command);
        notifyClients(command.getPizzaType(), command.getClient().getName());
        Pizza pizzaWithoutToppings = getPizzaByType(command);
        return addToppings(command.getToppings(), pizzaWithoutToppings);
    }

    private void preparePizza(Command command) throws InterruptedException {
        System.out.println("Starting making " + command.getPizzaType().toString() + " pizza for " + command.getClient().getName());
        Thread.sleep(4000);
        System.out.println("Pizza " + command.getPizzaType().toString() + " for " + command.getClient().getName() + " is ready");
    }

    private Pizza getPizzaByType(Command command) {
        if (PizzaType.CAPRICIOSA.equals(command.getPizzaType())) {
            return new Capriciosa();
        } else if (PizzaType.MARGUERITA.equals(command.getPizzaType())) {
            return new Marguerita();
        } else if (PizzaType.DIAVOLA.equals(command.getPizzaType())) {
            return new Diavola();
        }
        return null;
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }

    private Pizza addToppings(List<String> toppings, Pizza pizza) {
        PizzaDecorator pizzaWithToppings = new PizzaDecorator(pizza);
        for (String topping : toppings) {
            pizzaWithToppings = (PizzaDecorator) toppingFactory.getTopping(topping, pizzaWithToppings);
        }
        return pizzaWithToppings;
    }

    public void notifyClients(PizzaType pizzaType, String name) {
        for (Client client : clients) {
            client.checkPizza(pizzaType, name);
        }
    }
}
