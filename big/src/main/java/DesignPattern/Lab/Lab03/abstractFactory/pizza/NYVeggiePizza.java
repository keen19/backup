package DesignPattern.Lab.Lab03.abstractFactory.pizza;

public class NYVeggiePizza extends Pizza {
    @Override
    public void prepare() {

        setName("纽约素菜pizza");
        System.out.println("纽约素菜披萨 制作原材料");
    }
    @Override
    public void cost() {
        System.out.println("费用：$3.5");
    }
}
