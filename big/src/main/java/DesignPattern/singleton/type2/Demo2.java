package DesignPattern.singleton.type2;

public class Demo2 {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        System.out.println(instance.hashCode());
        SingleTon instance2 = SingleTon.getInstance();
        System.out.println(instance2.hashCode());


    }
}

//懒汉式(线程安全，同步方法)
class SingleTon{
    private static volatile SingleTon instance;

    //1.构造器私有化

    public SingleTon(){

    }

    //3.提供一个公有的静态方法,加入双层检查代码，解决线程安全问题，同时解决懒加载问题
    //
        public static synchronized SingleTon getInstance(){
        if (instance==null){
            synchronized (SingleTon.class){
                instance=new SingleTon();
            }
        }
            return instance;
        }
}

