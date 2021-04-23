package DesignPattern.Factory.pizza;

public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备胡椒披萨 制作原材料");
    }
}
