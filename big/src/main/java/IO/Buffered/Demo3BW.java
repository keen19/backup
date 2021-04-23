package IO.Buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo3BW {
    public static void main(String[] args) throws IOException {
        //1.创建BufferedWriter对象，构造方法中传递字符输出流
        FileWriter fw = new FileWriter("./src/main/java/IO/Buffered/2.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        //2.使用BufferedWriter的writer ( ) 方法，
        for (int i = 0; i < 10; i++) {
            bw.write("haha");
            bw.newLine();
        }
        //3.使用BufferedWriter的flush ( ) 方法，刷入数据
        bw.flush();
        //4.释放资源
        bw.close();

    }
}
