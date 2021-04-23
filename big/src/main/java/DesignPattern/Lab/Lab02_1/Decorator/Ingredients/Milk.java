package DesignPattern.Lab.Lab02_1.Decorator.Ingredients;

import DesignPattern.Lab.Lab02_1.Decorator.Decorator;
import DesignPattern.Lab.Lab02_1.Drink;

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("奶油");
        setPrice(0.10);
    }
}
