package IO.StringBuilder;

/*
    StringBuilder成员方法:
    public StringBuilder append(...) 添加任意类型数据的字符串形式,并返回对象自身
 */
public class Demo2 {
    public static void main(String[] args) {
        //创建StringBuilder对象
        StringBuilder bu1 = new StringBuilder();
        //使用append方法添加数据
        StringBuilder bu2 = bu1.append("abc");
        System.out.println(bu1);
        System.out.println(bu2);
        System.out.println(bu1 == bu2);//true 两个对象是同一对象

        //
        bu1.append("a");
        bu1.append("b");
        bu1.append("c");
        bu1.append("哈哈");
        System.out.println(bu1);
    }
}
