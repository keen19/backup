package IO.Buffered;

import java.io.*;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws IOException {
        //1.创建一个HashMap集合对象，可以存储每行文本的序号（1，2，3;value: 存储每行的文本
        HashMap<String, String> map = new HashMap<>();
        //2.创建字符缓冲输入流对象，构造方法绑定字符输入流
        BufferedReader br = new BufferedReader(
                new FileReader("./src/main/java/IO/Buffered/2.txt"));
        //3.创建字符缓冲输出流对象，构造方法绑定字符输出流
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("./src/main/java/IO/Buffered/3.txt"));
        //4.使用字符缓冲输入流中的readLine( ) 方法，逐行读取文本
        String line;
        while ((line=br.readLine())!=null){
            //5.把读取到的文本进行切割，获取行中的序号和文本内容
            String[] arr =line.split("\\.");
            //6.把切割好的序号和文本的内容存储到HashMap集合中
            map.put(arr[0],arr[1]);
        }
        //7.遍历HashMap集合，获取每一个键值对
        for (String key : map.keySet()) {
            String value=map.get(key);
            //8.把每一个键值对，拼接为一个文本行
            line=key + "."+value;
            //9.使用字符缓冲输出流的write ( ) 方法，写入到文件
            bw.write(line+"\n");
        }
        //10.释放资源
        bw.close();
        br.close();
    }
}
