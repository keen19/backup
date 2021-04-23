package DesignPattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //维护一个目标对象
    private Object target;

    //构造器,对target初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象 生成一个代理对象

    public Object getProxyInstance(){
        //说明

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("代理开始");
                    //反射机制调用目标对象的方法
                    //这里调用了代理被代理对象TeacherDao的teach方法
                    Object invoke = method.invoke(target, args);
                    System.out.println("代理结束");
                    return invoke;
                });
    }
}
