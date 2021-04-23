package DesignPattern.principle.lishitihuan;

public class A extends Base{
    //组合关系
    B b=new B();

    public int add2(int a, int b){
        return this.b.add(a,b);
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println("1+3="+a.add2(1, 3));
    }
}

class Base{

}

class B extends Base{
    public int add(int a, int b){
        return a+b;
    }
}

