package DesignPattern.Adapter.classadapter;

//被适配的类
public class Voltage220V {
    int src=220;
    public int output220V(){
        System.out.println("电压="+src+"伏");
        return src;
    }
}
