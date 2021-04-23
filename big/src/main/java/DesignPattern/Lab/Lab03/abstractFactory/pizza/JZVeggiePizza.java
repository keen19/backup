package DesignPattern.Lab.Lab03.abstractFactory.pizza;

public class JZVeggiePizza extends Pizza {
    @Override
    public void prepare() {

        setName("加州素菜pizza");
        System.out.println("加州素菜披萨 制作原材料");
    }
    @Override
    public void cost() {
        System.out.println("费用：$2.5");
    }
}
