package DesignPattern.Decorator;

public class Milk extends Decorator {
    /**
     * 传入被装饰者(咖啡)
     * @param obj
     */
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2);
    }
}