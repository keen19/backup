package IO.Properties;

import java.util.Properties;
import java.util.Set;

public class Demo1 {
    public static void main(String[] args) {
        show01();
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
