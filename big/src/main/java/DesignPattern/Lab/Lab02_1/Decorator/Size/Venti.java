package DesignPattern.Lab.Lab02_1.Decorator.Size;

import DesignPattern.Lab.Lab02_1.Decorator.Decorator;
import DesignPattern.Lab.Lab02_1.Drink;

public class Venti extends Decorator {
    public Venti(Drink obj) {
        super(obj);
        setDes("大杯");
        setPrice(0.20);
    }
}
