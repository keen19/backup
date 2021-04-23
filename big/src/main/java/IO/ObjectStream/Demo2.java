package IO.ObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.创建ObjectInputStream对象，构造方法中传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "./src/main/java/IO/ObjectStream/1.txt"));
        //2.使用ObjectInputStream的 readObject ( ) ，读取保存对象的文件
        Object o = ois.readObject();
        //3.释放资源
        ois.close();
        //4.使用读取出来的对象
        System.out.println(o);
        Person p = (Person) o;
        System.out.println(p.getAge()+p.getName());
    }
}
