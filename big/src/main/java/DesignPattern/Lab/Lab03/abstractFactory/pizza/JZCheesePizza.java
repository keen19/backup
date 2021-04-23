package DesignPattern.Lab.Lab03.abstractFactory.pizza;

public class JZCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("加州芝士pizza");
        System.out.println("加州芝士披萨 准备原材料");


    }

    @Override
    public void cost() {
        System.out.println("费用：$5.5");
    }
}
