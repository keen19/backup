package IO.inputstream;

import java.io.FileInputStream;

/*
    所有输入流都有成员方法:
    int read() : 从输入流中读取数据的下一个字节
    int read(byte[] b) : 从输入流中读取一定量的字节,并将其存储在缓冲区数组 b 中
    void close() : 关闭资源

    FileInputStream
        构造方法:
        FileInputStream(String name)   参数都是读取的文件
        FileInputStream(File file)

        作用:
        创建一个FileInputStream 对象
        会把FileInputStream对象指定构造方法中要读取的文件
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        //1.创建FileInputStream对象
        FileInputStream fis=new FileInputStream("./src/main/java/IO/b.txt");
        //2.使用FileInputStream对象中的read()方法,读取文件
        int len=0;
         while ((len=fis.read())!=-1) {
            System.out.println((char)len);
        }

        //3.释放资源
        fis.close();
    }
}
