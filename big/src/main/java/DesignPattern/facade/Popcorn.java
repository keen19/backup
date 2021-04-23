package DesignPattern.facade;

public class Popcorn {
    //使用单例模式,饿汉式
    private static Popcorn instance = new Popcorn();

    //返回一个实例(对象)
    public static Popcorn getInstance(){
        return instance;
    }
    public void on() {
        System.out.println("popcorn on");
    }

    public void off() {
        System.out.println("popcorn off");
    }

    public void pop() {
        System.out.println("popcorn is poping");
    }
}
