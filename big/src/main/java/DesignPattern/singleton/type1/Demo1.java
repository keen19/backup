package DesignPattern.singleton.type1;

public class Demo1 {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        //System.out.println(instance.hashCode());
        instance.print();

    }
}

//饿汉式(静态变量)
class SingleTon{
    //1.构造器私有化,外部不能new
    private SingleTon(){

    }

    //2.本类内部创建对象实例
    private static final SingleTon instance=new SingleTon();

    //3.提供一个公有的静态方法,返回实例对象
    public static SingleTon getInstance(){
        return instance;
    }
    public void print(){
        System.out.println("单例模式。。。");
    }
}
