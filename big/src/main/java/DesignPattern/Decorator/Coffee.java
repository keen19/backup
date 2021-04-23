package DesignPattern.Decorator;

//所有coffee的集合
public class Coffee extends Drink {
    @Override
    public double cost() {
        return super.getPrice();
    }
}
