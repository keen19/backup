package DesignPattern.Lab.Lab03.abstractFactory.order;

import DesignPattern.Lab.Lab03.abstractFactory.pizza.JZCheesePizza;
import DesignPattern.Lab.Lab03.abstractFactory.pizza.JZVeggiePizza;
import DesignPattern.Lab.Lab03.abstractFactory.pizza.Pizza;

public class JZFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza=null;
        if (orderType.equals("cheese")){
            pizza=new JZCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza=new JZVeggiePizza();
        }
        return pizza;
    }
}
