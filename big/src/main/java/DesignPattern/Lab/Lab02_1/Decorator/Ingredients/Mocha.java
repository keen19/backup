package DesignPattern.Lab.Lab02_1.Decorator.Ingredients;

import DesignPattern.Lab.Lab02_1.Decorator.Decorator;
import DesignPattern.Lab.Lab02_1.Drink;

public class Mocha extends Decorator {
    public Mocha(Drink obj) {
        super(obj);
        setDes("抹茶");
        setPrice(0.20);
    }
}
