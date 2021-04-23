package DesignPattern.Decorator;

public class Soy extends Decorator {
    /**
     * 传入被装饰者(咖啡)
     * @param obj
     */
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(1);
    }
}