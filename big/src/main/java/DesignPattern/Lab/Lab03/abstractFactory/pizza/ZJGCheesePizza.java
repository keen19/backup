package DesignPattern.Lab.Lab03.abstractFactory.pizza;

public class ZJGCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("芝加哥芝士pizza");
        System.out.println("芝加哥芝士披萨 准备原材料");


    }
    @Override
    public void cost() {
        System.out.println("费用：$6.5");
    }
}
