package IO.inputstream;

import java.io.FileInputStream;
import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        //创建FileInputStream对象
        FileInputStream fis = new FileInputStream("./src/main/java/IO/b.txt");
        //创建一个byte数组,用来存放字节
        byte[] bytes = new byte[1024];
        //调用read(),读取字节并放入数组
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
//            System.out.println(new String(bytes));
            //转换有效字节个数
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
    }
}
