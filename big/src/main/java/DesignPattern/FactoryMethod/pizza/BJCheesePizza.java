package DesignPattern.FactoryMethod.pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪pizza");
        System.out.println("北京奶酪披萨 准备原材料");


    }
}
