package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
    把b文件复制到c文件:
	1. 创建文件输入流(把要复制的文件输入到内存) -->读取步骤
	2. 创建文件输出流(把要复制的文件输出到内存) -->写入步骤
	3. 调用文件输入流的read( )方法读取文件 --> fis.read( )
    4. 调用文件输出流的 write( )方法 写入文件 --> fos.read( )
 */

public class CopyDemo {
    public static void main(String[] args) throws Exception{
        //创建读取对象FileInputStream  -->读取b文件
        FileInputStream fis = new FileInputStream("./src/main/java/IO/b.txt");
        //创建读取对象FileOutputStream  -->输出c文件
        FileOutputStream fos=new FileOutputStream("./src/main/java/IO/c.txt");
        //创建byte数组, 用来存放 读取的字节
        byte[] bytes=new byte[1024];
        //定义一个 有效字节个数
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
            System.out.println("复制完成");
        }
        //释放资源
        fis.close();
        fos.close();
    }
}
