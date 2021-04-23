package DesignPattern.Lab.Lab02_1;

public class Coffee extends Drink {
    @Override
    public double cost() {
        return super.getPrice();
    }
}
