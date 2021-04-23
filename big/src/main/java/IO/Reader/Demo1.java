package IO.Reader;

import java.io.FileReader;

public class Demo1 {
    public static void main(String[] args) throws Exception{
//1.创建 FileReader 对象 构造方法中绑定读取的数据源
        FileReader fileReader = new FileReader("./src/main/java/IO/b.txt");
//2.使用 FileReader 对象的read( ) 方法读取对象
        int len=0;//读取有效字符个数
        char[] chars=new char[1024];//存放读取的多个字符
        while ((len=fileReader.read(chars))!=-1){
            System.out.print(new String(chars,0,len));
        }
//3.释放资源
        fileReader.close();
    }

}
