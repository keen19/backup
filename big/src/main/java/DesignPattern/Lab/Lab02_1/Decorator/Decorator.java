package DesignPattern.Lab.Lab02_1.Decorator;

import DesignPattern.Lab.Lab02_1.Drink;

public class Decorator extends Drink {
    public Drink obj;
    public Drink obj2;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public double cost() {
        //返回装饰者价格和被装饰者价格
        return getPrice()+obj.cost();
    }

    @Override
    public String getDes() {
        //obj.getDes()  输出被装饰者的信息
        return des +super.getPrice() + "&&" + obj.getDes();
    }
}
