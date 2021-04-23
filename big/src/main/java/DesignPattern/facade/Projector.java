package DesignPattern.facade;

public class Projector {
    //使用单例模式,饿汉式
    private static Projector instance = new Projector();

    //返回一个实例(对象)
    public static Projector getInstance(){
        return instance;
    }
    public void on() {
        System.out.println("projector on");
    }

    public void off() {
        System.out.println("projector off");
    }

    public void pop() {
        System.out.println("projector is projector");
    }
}
