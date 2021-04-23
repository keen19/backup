package DesignPattern.facade;

public class DVDPlayer {

    //使用单例模式,饿汉式
    private static DVDPlayer instance = new DVDPlayer();

    //返回一个实例(对象)
    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("dvd on");
    }

    public void off() {
        System.out.println("dvd off");
    }

    public void pause() {
        System.out.println("dvd pause");
    }

    public void play() {
        System.out.println("dvd paly");
    }
}
