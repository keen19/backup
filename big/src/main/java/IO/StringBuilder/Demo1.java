package IO.StringBuilder;


public class Demo1 {
    public static void main(String[] args) {
        //无参构造
        StringBuilder sb=new StringBuilder();
        System.out.println("sb:"+sb);
        //带参数构造
        StringBuilder sb2 = new StringBuilder("abc");
        System.out.println("sb2:"+sb2);
    }
}
