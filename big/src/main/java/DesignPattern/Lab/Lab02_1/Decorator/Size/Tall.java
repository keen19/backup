package DesignPattern.Lab.Lab02_1.Decorator.Size;

import DesignPattern.Lab.Lab02_1.Decorator.Decorator;
import DesignPattern.Lab.Lab02_1.Drink;

public class Tall extends Decorator {
    public Tall(Drink obj) {
        super(obj);
        setDes("小杯");
        setPrice(0.10);
    }
}
