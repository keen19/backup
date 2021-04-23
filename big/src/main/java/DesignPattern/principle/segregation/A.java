package DesignPattern.principle.segregation;

public class A {
    public void oper1(Interface1 interface1){
        interface1.fanfa1();
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        //A类通过接口方法去依赖B类
        a.oper1(b);
        d.oper2(c);
    }
}

class D{
    public void oper2(Interface2 interface2){
        interface2.fanfa2();
    }
}

class B implements Interface1{
    @Override
    public void fanfa1() {
        System.out.println("B 实现了接口1的 1方法");
    }
}
class C implements Interface2{
    @Override
    public void fanfa2() {
        System.out.println("C 实现了接口2的 2方法");
    }
}
interface Interface1{
    void fanfa1();

}
interface Interface2{
    void fanfa2();
}
