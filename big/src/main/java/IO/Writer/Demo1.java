package IO.Writer;

import java.io.FileOutputStream;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        //1.创建 FileReader 对象 构造方法中绑定写入的数据目的地
        FileOutputStream fos = new FileOutputStream("./src/main/java/IO/d.txt");
        //2.使用 FileReader 对象的write( ) 把数据写入到内存缓冲区中
        fos.write(97);
        //3.使用 FileReader 的flush( ) ，把内存缓冲区的数据，刷新到文件中
        fos.flush();
        //4.释放资源
        fos.close();
    }
}
