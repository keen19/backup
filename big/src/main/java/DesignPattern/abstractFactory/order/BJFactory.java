package DesignPattern.abstractFactory.order;

import DesignPattern.abstractFactory.pizza.BJCheesePizza;
import DesignPattern.abstractFactory.pizza.BJPepperPizza;
import DesignPattern.abstractFactory.pizza.Pizza;

public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza=null;
        if (orderType.equals("cheese")){
            pizza=new BJCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza=new BJPepperPizza();
        }
        return pizza;
    }
}
