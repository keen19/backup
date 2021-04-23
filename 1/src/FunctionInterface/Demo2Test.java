package FunctionInterface;

import java.util.function.Supplier;

/*
    求数组元素最大值
    使用supplier接口 并通过Lambda表达式
 */
public class Demo2Test {
    public static  int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        //定义int数组
        int[] arr={111,222,333,444,66,77,12};
        //调用getMax方法 方法的参数是一个函数式接口 所以可以用Lambda表达式
        int maxValue=getMax(()->{
            //获取数组的最大值，并返回
        //定义一个变量，把数组中的第一个元素赋值给该变量，记录数组中的最大值
        int max=arr[0];
        //foreach遍历数组
            for(int i:arr){
                if(i>max){
                    //如果i>max，则替换max
                    max=i;
                }
            }
            //返回最大值
            return max;
        });
        System.out.println(maxValue);
    }
}
