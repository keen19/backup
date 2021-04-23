package DesignPattern.Lab.Lab06_2;

public class PureSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        System.out.println("不加入配料");
    }
    @Override
    boolean hook(){
        return false;
    }
}
