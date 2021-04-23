package DesignPattern.Lab.Lab02_1;

import DesignPattern.Lab.Lab02_1.Concretecomponet.Decaf;
import DesignPattern.Lab.Lab02_1.Concretecomponet.HouseBlend;
import DesignPattern.Lab.Lab02_1.Decorator.Ingredients.Milk;
import DesignPattern.Lab.Lab02_1.Decorator.Ingredients.Mocha;
import DesignPattern.Lab.Lab02_1.Decorator.Ingredients.Soy;
import DesignPattern.Lab.Lab02_1.Decorator.Ingredients.Whip;
import DesignPattern.Lab.Lab02_1.Decorator.Size.Grande;
import DesignPattern.Lab.Lab02_1.Decorator.Size.Tall;

public class Main {
    public static void main(String[] args) {
        Drink decaf = new Decaf();
        System.out.println("费用:"+decaf.getPrice());
        System.out.println("描述:"+decaf.getDes());

        decaf = new Milk(decaf);
        System.out.println("加入牛奶的费用:"+decaf.cost());
        decaf = new Tall(decaf);
        System.out.println("小杯牛奶无咖啡因"+decaf.cost());
        System.out.println("==================");

        System.out.println("一中杯双Mocha、Soy、Whip的HouseBlend咖啡"
        +new Grande(
                new Mocha(new Mocha
                        (new Soy(new Soy
                                (new Whip(new Whip
                                        (new HouseBlend()))))))).cost());
    }
}
