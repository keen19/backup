package DesignPattern.Lab.Lab02_1.Decorator.Ingredients;

import DesignPattern.Lab.Lab02_1.Decorator.Decorator;
import DesignPattern.Lab.Lab02_1.Drink;

public class Whip extends Decorator {
    public Whip(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(0.10);
    }
}
