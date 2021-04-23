package DesignPattern.proxy.cglib;

public class Client {
    public static void main(String[] args) {
        //创建目标对象
        TeacherDao teacherDao = new TeacherDao();
        //获取到代理对象,并且传递给代理对象
        TeacherDao proxyFactory = (TeacherDao) new ProxyFactory(teacherDao)
                .getProxyInstance();
        //执行代理对象的方法,触发intercept
        proxyFactory.teach();
    }
}
