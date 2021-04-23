package reflect;

/**
 * 获取Class对象的方式
 * 1.Class.forName("全类名"),将字节码文件加载进内存,返回Class对象
 * 2.类名.class:通过类名的属性class获取
 * 3.对象.getClass():getClass()方法在Object类中定义着
 */
public class RelectDemo01 {
    public static void main(String[] args) throws Exception {
//        1.获取全类名-->Class.forName("全类名")
        Class cls1 = Class.forName("reflect.Person");
        System.out.println(cls1);
        //2.类名.class
        Class personClass = Person.class;
        System.out.println(personClass);
        //对象.getClass()
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);
        System.out.println(cls3 == cls1);
    }
}
