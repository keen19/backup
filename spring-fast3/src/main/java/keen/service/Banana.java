package keen.service;

public class Banana implements Fruit {
    @Override
    public void eat() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("吃香蕉");
    }
}
