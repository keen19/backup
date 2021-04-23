package DesignPattern.Lab.Lab06_2;

public class Client {
    public static void main(String[] args) {
        RedSoyaMilk redSoyaMilk = new RedSoyaMilk();
        redSoyaMilk.make();
        System.out.println("===========");
        PureSoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
