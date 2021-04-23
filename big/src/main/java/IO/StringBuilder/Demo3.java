package IO.StringBuilder;

/*
    StringBuilder 和String可以相互转换;
    String 可以用Stringbuilder的构造方法;
    StringBuilder 可以用String的toString()方法
 */
public class Demo3 {
    public static void main(String[] args) {
        String s="abc";
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(stringBuilder.toString());
    }
}
