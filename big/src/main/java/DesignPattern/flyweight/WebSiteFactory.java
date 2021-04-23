package DesignPattern.flyweight;

import java.util.HashMap;

public class WebSiteFactory {

    //集合 ,充当池的作用
    private HashMap<String,ConcreteWebSite> pool=new HashMap<>();

    //根据网站的类型,返回一个网站,如果没有就创建一个网站,并放入池中,再返回
    public WebSite getWebSiteCategory(String type){
        if (!pool.containsKey(type)){
            //就创建一个网站,并放入池中
            pool.put(type,new ConcreteWebSite(type));
        }
        return pool.get(type);
    }


    //获取网站总数
    public int WebSitecount(){
        return pool.size();
    }
}
