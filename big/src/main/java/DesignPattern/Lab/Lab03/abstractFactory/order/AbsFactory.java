package DesignPattern.Lab.Lab03.abstractFactory.order;

import DesignPattern.Lab.Lab03.abstractFactory.pizza.Pizza;

public interface AbsFactory {
    //让下面的工厂子类来具体实现
    public Pizza createPizza(String orderType);
}
