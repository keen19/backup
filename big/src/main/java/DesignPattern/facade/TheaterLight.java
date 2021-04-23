package DesignPattern.facade;

public class TheaterLight {
    //使用单例模式,饿汉式
    private static TheaterLight instance = new TheaterLight();

    //返回一个实例(对象)
    public static TheaterLight getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("TheaterLight on");
    }
    public void off() {
        System.out.println("TheaterLight off");
    }

    public void dim() {
        System.out.println("TheaterLight dim");
    }

    public void bright(){
        System.out.println("TheaterLight bright");
    }
}
