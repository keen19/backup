package DesignPattern.visitor;

import java.util.Random;

public class Engineer extends Staff {
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    //一年做的代码数量
    public int getCodeCount(){
        return new Random().nextInt(10*10000);
    }
}
