package IO.ObjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        //1.创建ObjectOutputStream对象，构造方法中传递字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "./src/main/java/IO/ObjectStream/1.txt"));
        //2.使用ObjectOutputStream的 writeObject ( ) ，把对象写入到文件中
        oos.writeObject(new Person("美女",18));
        //3.释放资源
        oos.close();
    }
}
