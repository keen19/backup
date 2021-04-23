package DesignPattern.Lab.Lab03.abstractFactory.order;

import DesignPattern.Lab.Lab03.abstractFactory.pizza.NYCheesePizza;
import DesignPattern.Lab.Lab03.abstractFactory.pizza.NYVeggiePizza;
import DesignPattern.Lab.Lab03.abstractFactory.pizza.Pizza;

public class NYFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza=null;
        if (orderType.equals("cheese")){
            pizza=new NYCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza=new NYVeggiePizza();
        }
        return pizza;
    }
}
