package DesignPattern.singleton.type4;

import javax.print.DocFlavor;

public class Demo4 {
    public static void main(String[] args) {
        SingleTom instance = SingleTom.instance;
        SingleTom instance2 = SingleTom.instance;
        System.out.println(instance==instance2);
    }
}

//枚举方式
enum SingleTom{
    instance;
    public void sayOK(){
        System.out.println("ok");
    }
}
