package DesignPattern.singleton.type3;



public class Demo3 {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        System.out.println(instance.hashCode());
        SingleTon instance2 = SingleTon.getInstance();
        System.out.println(instance2.hashCode());
    }
}

//静态内部类完成
class SingleTon{
    //1.构造器私有化
    private SingleTon(){

    }

    //写一个静态内部类，该类中有一个静态属性SingleTon
    private static class SingleTonInstance{
        private static final SingleTon instance =new SingleTon();
    }

    //3.提供一个公有的静态方法,加入双层检查代码，解决线程安全问题，同时解决懒加载问题
    //
    public static  SingleTon getInstance(){
        return SingleTonInstance.instance;
    }
}


