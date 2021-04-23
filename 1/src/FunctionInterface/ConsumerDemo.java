package FunctionInterface;

import java.lang.reflect.Method;
import java.util.function.Consumer;

/**
 *   Consumer接口是一个消费型接口，泛型执行什么类型，就可以使用accept方法消费什么类型的数据
 *  至于具体怎么消费（使用），需要自定义{输出，计算}
 * @author keen1
 */
public class ConsumerDemo {
    /**
    定义一个方法
    方法的参数传递一个字符串的姓名
    方法的参数传递Comsumer接口泛型为String
    使用Consumer接口消费字符串的姓名
     */
    public  static void  method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args) {
        method("jee",(String name)->{
            //对传递的字符串消费
            //消费方式：直接输出字符串
            System.out.println(name);
            //消费方式：把字符串进行反转输出
            String reName=new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });
    }
}
