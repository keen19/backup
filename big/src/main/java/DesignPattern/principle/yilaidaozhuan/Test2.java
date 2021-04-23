//package DesignPattern.principle.yilaidaozhuan;
//
//public class Test2 {
//    public static void main(String[] args) {
//        B b=new B();
//        A a = new A(new B());
//    }
//}
//
//class A{
//    public A(jiekouleixing jiekouleixing) {
//        jiekouleixing.say();
//    }
//}
//
//interface jiekouleixing{
//    void say();
//}
//
//class B implements jiekouleixing{
//    @Override
//    public void say(){
//        System.out.println("通过构造方法调用");
//    }
//}
