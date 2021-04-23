package DesignPattern.Factory.order;

import DesignPattern.Factory.pizza.CheesePizza;
import DesignPattern.Factory.pizza.GreekPizza;
import DesignPattern.Factory.pizza.PepperPizza;
import DesignPattern.Factory.pizza.Pizza;

public class SimpleFactory {
    public Pizza createPizze(String orderType){

        Pizza pizza=null;

        System.out.println("使用简单工厂模式");

        if (orderType.equals("greek")){
            pizza=new GreekPizza();
            pizza.setName("希腊披萨");
        }else if (orderType.equals("cheese")){
            pizza=new CheesePizza();
            pizza.setName("奶酪披萨");
        }else if (orderType.equals("pepper")){
            pizza=new PepperPizza();
            pizza.setName("胡椒披萨");
    }
        return pizza;
}
}
