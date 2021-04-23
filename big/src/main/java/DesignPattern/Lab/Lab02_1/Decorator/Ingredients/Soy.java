package DesignPattern.Lab.Lab02_1.Decorator.Ingredients;

import DesignPattern.Lab.Lab02_1.Decorator.Decorator;
import DesignPattern.Lab.Lab02_1.Drink;

public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(0.15);
    }
}
