package IO.Buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo2BIS {
    public static void main(String[] args) throws IOException {
        //1.创建FileInputStream对象，构造方法绑定文件
        FileInputStream fis = new FileInputStream("./src/main/java/IO/Buffered/1.txt");
        //2.创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream效率
        BufferedInputStream bis = new BufferedInputStream(fis);
        //3.使用BufferedInputStream的read ( ) 方法，
        int len=0;
        byte[] bytes=new byte[1024];
        while ((len=bis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        //4.释放资源
        bis.close();
    }
}
