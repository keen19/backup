package DesignPattern.FactoryMethod.order;

import DesignPattern.FactoryMethod.pizza.*;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        System.out.println("使用抽象工厂模式");

        Pizza pizza=null;
        if (orderType.equals("cheese")){
            pizza=new LDCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza=new LDPepperPizza();
        }
        return pizza;
    }
}
