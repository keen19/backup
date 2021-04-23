package DesignPattern.Lab.Lab02_1.Decorator.Size;

import DesignPattern.Lab.Lab02_1.Decorator.Decorator;
import DesignPattern.Lab.Lab02_1.Drink;

public class Grande extends Decorator {
    public Grande(Drink obj) {
        super(obj);
        setDes("中杯");
        setPrice(0.15);
    }
}
