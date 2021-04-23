package FunctionInterface;

import java.util.function.Consumer;

/**
 * @author keen1
 */
public class Consumer3 {
    //定义一个方法，参数传递String类型的数组和两个Consumer接口，泛型使用String
    public static void pringInfo(String[] arr, Consumer<String>con1,Consumer<String> con2){
        //遍历字符串数组
        for(String message:arr){
            con1.andThen(con2).accept(message);
        }
    }

    public static void main(String[] args) {
        String[] arr={"迪丽热巴,女","张三,男","keen,男"};
        pringInfo(arr,(message)->{
            //消费方式：对message切割，获取姓名，
            String name=message.split(",")[0];
            System.out.print("姓名:"+name);
        },(message)->{
            //消费方式：对message切割，获取年龄
            String age=message.split(",")[1];
            System.out.println("。性别:"+age+"。");
        });
    }
}
