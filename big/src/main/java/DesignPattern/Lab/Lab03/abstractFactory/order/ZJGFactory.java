package DesignPattern.Lab.Lab03.abstractFactory.order;

import DesignPattern.Lab.Lab03.abstractFactory.pizza.*;

public class ZJGFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza=null;
        if (orderType.equals("cheese")){
            pizza=new ZJGCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza=new ZJGVeggiePizza();
        }
        return pizza;
    }
}
