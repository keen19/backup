package IO.bianma;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        write_utf_8();
    }

    private static void write_utf_8() throws IOException {
        //1.创建OutputStreamWriter对象，构造方法中传递字节流和指定的编码表名称
        FileOutputStream fos = new FileOutputStream("./src/main/java/IO/bianma/1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
        //2.使用OutputStreamWriter对象的write( ),把字符转换为字节存储缓冲区中(编码)
        osw.write("你好");
        //3.使用OutputStreamWriter对象的flush( ),把内存缓冲区中的字节刷新到文件中(使用字节流写字节的过程)
        osw.flush();
        //4.释放资源
        fos.close();
        osw.close();
    }
}
