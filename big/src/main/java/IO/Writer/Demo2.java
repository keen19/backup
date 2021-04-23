package IO.Writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        //1.创建 FileReader 对象 构造方法中绑定写入的数据目的地
        FileWriter fw = new FileWriter("./src/main/java/IO/d.txt");
        char[] chars={'1','2','a','b','c'};
        //2.使用 FileReader 对象的write( ) 把数据写入到内存缓冲区中
        fw.write(chars,1,3);
        fw.write("我是程序猿",1,3);
        //3.使用 FileReader 的flush( ) ，把内存缓冲区的数据，刷新到文件中
        fw.flush();
        //4.释放资源
        fw.close();
    }
}
