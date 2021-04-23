package DesignPattern.FactoryMethod.order;

import DesignPattern.FactoryMethod.pizza.Pizza;
import DesignPattern.FactoryMethod.pizza.BJCheesePizza;
import DesignPattern.FactoryMethod.pizza.BJPepperPizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
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
