package keen.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author keen1
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties properties;

    //定义一个Map容器,存放对象
    private static Map<String, Object> beans;

    static {
        //实例化对象
        properties = new Properties();
        //获取properties文件的流对象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            //加载
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //实例化容器
        beans=new HashMap<String, Object>();
        //取出keys
        Enumeration keys=properties.keys();
        //遍历枚举
        while (keys.hasMoreElements()){
            //取出每个Key
            String key=keys.nextElement().toString();
            //根据key获取value
            String beanPath=properties.getProperty(key);
            //反射创建对象
            try {
                Object value=Class.forName(beanPath).newInstance();
                //把key和value放入容器
                beans.put(key, value);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取一个bean对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
        /*Object bean = null;
        try {
            String beanPath = properties.getProperty(beanName);
            System.out.println(beanPath);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;*/
    }
}
