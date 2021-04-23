package DesignPattern.proxy.dynamicproxy;


public class Client {
    public static void main(String[] args) {
        //创建目标对象
        ITeacherDao target = new TeacherDao();
        //给目标对象,创建代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).
                getProxyInstance();
        System.out.println(proxyInstance.getClass());
        System.out.println("=======");
        proxyInstance.teach();
        System.out.println("=======");
        proxyInstance.say("你好",10);
    }
}
