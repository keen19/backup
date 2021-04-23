package DesignPattern.principle.yilaidaozhuan;

public class Test3 {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        a.setter(b);
        a.say2();
    }
}

interface Ajiekou {
    void setter(jiekouleixing jiekouleixing);

    void say2();
}

interface jiekouleixing {
    void say();
}

class A implements Ajiekou {

    jiekouleixing jiekouleixing;

    @Override
    public void setter(jiekouleixing jiekouleixing) {
        this.jiekouleixing = jiekouleixing;
    }

    @Override
    public void say2() {
        jiekouleixing.say();
    }

}

class B implements jiekouleixing {
    @Override
    public void say() {
        System.out.println("通过setter调用");
    }
}

