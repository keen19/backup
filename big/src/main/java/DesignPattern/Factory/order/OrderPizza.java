package DesignPattern.Factory.order;

import DesignPattern.Factory.pizza.CheesePizza;
import DesignPattern.Factory.pizza.GreekPizza;
import DesignPattern.Factory.pizza.PepperPizza;
import DesignPattern.Factory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    //构造器
//    public OrderPizza(){
//        Pizza pizza=null;
//        String orderType;//订购披萨的类型
//        do{
//            orderType=getType();
//            if (orderType.equals("greek")){
//                pizza=new GreekPizza();
//                pizza.setName("希腊披萨");
//            }else if (orderType.equals("cheese")){
//                pizza=new CheesePizza();
//                pizza.setName("奶酪披萨");
//            }else if (orderType.equals("pepper")){
//                pizza=new PepperPizza();
//                pizza.setName("胡椒披萨");
//            }else {
//                break;
//            }
//            //输出pizza制作过程
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        }while (true);
//    }

    public OrderPizza(SimpleFactory simpleFactory){
        setFactory(simpleFactory);
    }
    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza=null;
    public  void setFactory(SimpleFactory simpleFactory){
        String orderType="";
        this.simpleFactory=simpleFactory;//设置简单工厂对象
        do {
            orderType=getType();
            pizza = this.simpleFactory.createPizze(orderType);
            //输出pizza
            if (pizza!=null){//订购成功
                pizza.prepare();;
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购披萨失败");
                break;
            }
        }while (true);
    }

    //写一个方法，获取客户希望订购的披萨种类
    private String getType(){
        try {
            BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str=strin.readLine();
            return str;
        }catch (IOException e){
            e.printStackTrace();;
            return "";
        }
    }
}
