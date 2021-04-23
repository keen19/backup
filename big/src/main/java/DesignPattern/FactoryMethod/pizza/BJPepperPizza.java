package DesignPattern.FactoryMethod.pizza;

public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {

        setName("北京胡椒pizza");
        System.out.println("北京胡椒披萨 制作原材料");
    }
}
