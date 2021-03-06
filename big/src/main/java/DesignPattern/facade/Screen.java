package DesignPattern.facade;

public class Screen {
    //使用单例模式,饿汉式
    private static Screen instance = new Screen();

    //返回一个实例(对象)
    public static Screen getInstance(){
        return instance;
    }
    public void up() {
        System.out.println("screen up");
    }

    public void down() {
        System.out.println("screen down");
    }
}
