package DesignPattern.Lab.Lab03.abstractFactory.pizza;

public class NYCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("纽约芝士pizza");
        System.out.println("纽约芝士披萨 准备原材料");


    }
    @Override
    public void cost() {
        System.out.println("费用：$8.5");
    }
}
