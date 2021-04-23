package DesignPattern.bridge;

public class Client {
    public static void main(String[] args) {
        //折叠式手机(样式+品牌)
        Phone phone = new FoldedPhone(new XiaoMi());
        phone.open();
        phone.call();
        phone.close();
        System.out.println("=============");
        Phone phone1=new FoldedPhone(new Vivo());
        phone1.open();
        phone1.call();
        phone1.close();
    }
}
