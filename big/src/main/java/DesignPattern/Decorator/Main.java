package DesignPattern.Decorator;

public class Main {
    public static void main(String[] args) {
        //装饰者模式下的订单：2份巧克力+一份牛奶的LongBlack

        //1. 点一份LongBlack
        Drink longBlack = new LongBlack();
        System.out.println("费用："+longBlack.getPrice());
        System.out.println("描述："+longBlack.getDes());

        //2.加入一份牛奶
        longBlack=new Milk(longBlack);
        System.out.println("加入一份牛奶的费用："+longBlack.cost());
        System.out.println("加入一份牛奶的描述："+longBlack.getDes());

        //3.加入一份巧克力
        longBlack=new Chocolate(longBlack);
        System.out.println("加入一份牛奶和一份巧克力的费用：" + longBlack.cost());
        System.out.println("加入一份牛奶和一份巧克力的描述：" + longBlack.getDes());

        //4.加入一份巧克力
        longBlack=new Chocolate(longBlack);
        System.out.println("加入一份牛奶和2份巧克力的费用：" + longBlack.cost());
        System.out.println("加入一份牛奶和2份巧克力的描述：" + longBlack.getDes());
    }
}
