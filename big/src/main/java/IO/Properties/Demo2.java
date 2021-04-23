package IO.Properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        show03();
    }

    private static void show03() throws IOException {
        //1.创建Properties集合对象
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("./src/main/java/IO/Properties/1.txt");
        //2.使用Properties集合对象中的 load ( ) 方法 读取保存键值对的文件
        properties.load(fileReader);
        //3.遍历Properties集合
        Set<String> set=properties.stringPropertyNames();
        for (String key : set) {
            String value=properties.getProperty(key);
            System.out.println(key+"="+value);
        }
    }

    private static void show02() throws IOException {
        Properties properties = new Properties();
        //使用setProperty往集合中添加数据
        properties.setProperty("赵丽颖","168");
        properties.setProperty("迪丽热巴","155");
        properties.setProperty("古力娜扎","160");
        FileWriter fileWriter = new FileWriter(
                "./src/main/java/IO/Properties/1.txt");
        properties.store(fileWriter,"save data");
        fileWriter.close();
    }

    private static void show01() {
        //创建properties 集合对象
        Properties properties = new Properties();
        //使用setProperty往集合中添加数据
        properties.setProperty("赵丽颖","168");
        properties.setProperty("迪丽热巴","155");
        properties.setProperty("古力娜扎","160");

        //使用StringPerpertyNames把Properties集合的键取出,存储到一个Set集合中
        Set<String> set=properties.stringPropertyNames();

        //遍历Set集合,取出Properties中的每一个键
        for (String key : set) {
            //使用getProperty()方法通过key获取value
            String value=properties.getProperty(key);
            System.out.println(key+"="+value);
        }
    }
}
