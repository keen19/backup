package DesignPattern.Lab.Lab03.abstractFactory.order;

public class PizzaStore {
    public static void main(String[] args) {

        new OrderPizza(new JZFactory());
    }
}
