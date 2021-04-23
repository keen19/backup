package DesignPattern.template;

public class Client {
    public static void main(String[] args) {
        RedSoyaMilk redSoyaMilk = new RedSoyaMilk();
        redSoyaMilk.make();
        System.out.println("===========");
        PureSoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
