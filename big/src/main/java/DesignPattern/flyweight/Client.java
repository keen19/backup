package DesignPattern.flyweight;

public class Client {
    public static void main(String[] args) {
        //创建一个工厂类
        WebSiteFactory factory=new WebSiteFactory();

        //客户要一个以新闻形式发布的网站
        WebSite webSite = factory.getWebSiteCategory("新闻");
        webSite.user(new User("tom"));

        WebSite webSite1=factory.getWebSiteCategory("新闻");
        webSite1.user(new User("jack"));

        WebSite webSite2=factory.getWebSiteCategory("体育");
        webSite2.user(new User("uzi"));
        System.out.println("网站总数:"+factory.WebSitecount());
    }
}
