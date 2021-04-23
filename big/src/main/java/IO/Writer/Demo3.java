package IO.Writer;

import java.io.FileWriter;

public class Demo3 {
    public static void main(String[] args) throws Exception{
        FileWriter fw=new FileWriter("./src/main/java/IO/d.txt",true);
        fw.write("这是续写的文字");
        fw.flush();
        fw.close();
    }

}
