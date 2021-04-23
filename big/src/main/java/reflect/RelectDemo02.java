package reflect;
/*	1. 获取成员变量们
        a. Field[] getFields()
        b. Field getField(String name)

        a. Field[] getDeclaredFields()
        b. Field getDeclaredField(String name)
    2. 获取构造方法们
        a. Constructor<?>[] getConstructors()
        b. Constructor<T> getConstructor(类<?>... parameterTypes)

        c. Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
        d. Constructor<?>[] getDeclaredConstructors()
    3. 获取成员方法们
        a. Method[] getMethods()
        b. Method getMethod(String name, 类<?>... parameterTypes)
        c. Method[] getDeclaredMethods()
        d. Method getDeclaredMethod(String name, 类<?>... parameterTypes)
    4. 获取类名
        a. String getName()*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RelectDemo02 {
    public static void main(String[] args) throws Exception {
        //获取person的Class对象
        Class personClass = Person.class;
        Field[] fields=personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        //Field getField(String name)
        Field a = personClass.getField("a");
        //获取a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"张三");
        Object value1 = a.get(p);
        System.out.println(p);

        System.out.println("==========");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field name=personClass.getDeclaredField("name");
        //忽略访问权限修饰符的安装检查
        name.setAccessible(true);
        Object value2 = name.get(p);
        System.out.println(value2);
        System.out.println("=========");

        //获取指定构造器
        Constructor constructor = personClass.getConstructor(String.class,String.class);
        System.out.println(constructor);
        //创建对象
        Object o = constructor.newInstance("张三","18");
        System.out.println(o);
        System.out.println("===========");

        //获取指定名称的方法
        Method eat = personClass.getMethod("eat");
        Person p1 = new Person();
        //执行方法
        eat.invoke(p1);
    }
}
