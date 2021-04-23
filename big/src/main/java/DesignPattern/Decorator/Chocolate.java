package DesignPattern.Decorator;

//具体的Decorator，这里就是调味品
public class Chocolate extends Decorator {
    /**
     * 传入被装饰者(咖啡)
     * @param obj
     */
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3);
    }
}
