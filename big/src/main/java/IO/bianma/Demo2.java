package IO.bianma;

import java.io.*;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        read_utf_8();
    }

    private static void read_utf_8() throws IOException {
        //1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
        FileInputStream fis = new FileInputStream("./src/main/java/IO/bianma/1.txt");
        //2.使用InputStreamReader对象的 read( ) 读取文件
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        int len=0;
        while ((len=isr.read())!=-1){
            System.out.print((char) len);
        }
        //3.释放资源
        fis.close();
        isr.close();
    }
}
