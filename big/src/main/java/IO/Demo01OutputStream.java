package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * OutputStream 字节输出流
 * FileOutputStream 文件字节输出流:把内存中的数据写入到硬盘的文件中
 *
 * 写入数据的原理：java程序-->JVM(java虚拟机)-->OS系统(操作系统)-->OS调用写数据的方法-->把数据写入到文件
 *
 * 字节输出流的使用步骤:
 * 1.创建一个FileOutputStream对象 构造方法中传递写入数据的目的地
 * 2.调用FileOutputStream对象中的write()方法,把数据写入到文件
 * 3.释放资源
 */

public class Demo01OutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建一个FileOutputStream对象 构造方法中传递写入数据的目的地
        FileOutputStream fos = new FileOutputStream("./src/main/java/IO/a.txt");
        //2.调用FileOutputStream对象中的write()方法,把数据写入到文件
        fos.write(98);
        //3.释放资源
        fos.close();
    }
}
