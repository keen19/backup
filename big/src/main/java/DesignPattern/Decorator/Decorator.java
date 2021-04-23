package DesignPattern.Decorator;

public class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink obj) {//组合
        this.obj = obj;
    }

    @Override
    public double cost() {
        //getPrice() 装饰者自己的价格
        //返回被装饰者和装饰者的价格
        return getPrice()+obj.cost();

    }

    @Override
    public String getDes() {
        //obj.getDes()  输出被装饰者的信息
        return des +super.getPrice() + "&&" + obj.getDes();
    }
}
