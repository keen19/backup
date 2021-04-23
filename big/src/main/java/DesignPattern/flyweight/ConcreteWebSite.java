package DesignPattern.flyweight;

public class ConcreteWebSite extends WebSite {
    //网站发布类型,共享的部分,内部状态
    private String type = "";

    @Override
    public void user(User user){
        System.out.println("网站类型:"+type+" "+"使用者:"+user.getName());

    }

    public ConcreteWebSite(String type) {
        this.type = type;
    }
}
