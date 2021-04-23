package DesignPattern.abstractFactory.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {

        setName("伦敦胡椒pizza");
        System.out.println("伦敦胡椒披萨 制作原材料");
    }
}
