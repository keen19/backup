package FunctionInterface;

import java.util.function.Supplier;

public class Demo1Supplier {
    //获取一个泛型参数指定类型的对象数据。
//    Supplier<T>接口是生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会生产什么类型的数据。
    public static Integer getString(Supplier<Integer> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        //调用getString方法，方法的supplier是一个函数式接口，使用lambda表达式
        Integer s=getString(()->{
            //生产一个字符串,并返回
            return 1;
        });
        //优化Lambda
        Integer s2=getString(()->2);
        System.out.println(s2);

    }
}
