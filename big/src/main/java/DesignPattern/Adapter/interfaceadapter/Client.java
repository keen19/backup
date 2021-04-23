package DesignPattern.Adapter.interfaceadapter;

public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter=new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("这是m1()方法");
            }
        };
        absAdapter.m1();
    }
}
