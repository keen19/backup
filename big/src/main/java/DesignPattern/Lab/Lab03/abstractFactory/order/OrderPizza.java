package DesignPattern.Lab.Lab03.abstractFactory.order;

import DesignPattern.Lab.Lab03.abstractFactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    AbsFactory factory;

    //构造器
    public OrderPizza(AbsFactory factory){
        setFactory(factory);
    }

    public void setFactory(AbsFactory factory) {
        Pizza pizza = null;
        String orderType = "";
        this.factory = factory;

        do {
            orderType = getType();
            pizza=factory.createPizza(orderType);
            if (pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                pizza.cost();
            }else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
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

