package DesignPattern.facade;

public class Stereo {
    //使用单例模式,饿汉式
    private static Stereo instance = new Stereo();

    //返回一个实例(对象)
    public static Stereo getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("stereo on");
    }
    public void off() {
        System.out.println("stereo off");
    }
}
