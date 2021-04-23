package IO.Buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1BOS {
    public static void main(String[] args) throws IOException {
        //1.创建FileOutputStream对象，构造方法绑定文件
        FileOutputStream fos = new FileOutputStream("./src/main/java/IO/Buffered/1.txt");
        //2.创建BufferedOutputStream对象，构造方法中传递FileOutputStream对象，提高FileOutputStream效率
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //3.使用BufferedOutputStream的write ( ) 方法，
        bos.write("我是".getBytes());
        //4.使用BufferedOutputStream的flush ( ) 方法
        bos.flush();
        //5.释放资源
        bos.close();

    }
}
