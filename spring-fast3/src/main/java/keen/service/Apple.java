package keen.service;

public class Apple implements Fruit {
    @Override
    public void eat() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ĺčšć");
    }
}
