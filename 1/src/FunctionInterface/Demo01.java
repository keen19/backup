package FunctionInterface;

public class Demo01 {
    public static void PrintString(Printable p){
        p.print("Hello");
    }

    public static void main(String[] args) {
        Demo01 demo01=new Demo01();
        PrintString(System.out::println);
    }
}
