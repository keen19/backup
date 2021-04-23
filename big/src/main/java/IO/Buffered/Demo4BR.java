package IO.Buffered;

import java.io.*;

public class Demo4BR {
    public static void main(String[] args) throws IOException {
        //1.创建BufferedReader 对象，构造方法中传递字符输入流
        FileReader fw = new FileReader("./src/main/java/IO/Buffered/1.txt");
        BufferedReader br = new BufferedReader(fw);
        //2.使用BufferedReader 的read( )或 readLine( ) 读取文本
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);

        }
        //3.释放资源
        br.close();
    }
}
