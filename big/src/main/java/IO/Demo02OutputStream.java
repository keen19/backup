package IO;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 一次写多个字节的方法
 *  public void write (byte [] b]:将b.length字节从指定的字节数组写入此输出流
 */

public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建一个FileOutputStream对象 构造方法中传递写入数据的目的地
        FileOutputStream fos = new FileOutputStream("./src/main/java/IO/b.txt");
        //2.调用FileOutputStream对象中的write()方法,把数据写入到文件
//        fos.write(49);
//        fos.write(48);
//        fos.write(48);

        byte[] bytes="你好".getBytes();
        fos.write(bytes);
        //3.释放资源
        fos.close();
    }
}
