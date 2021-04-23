package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LenovoTest {
    public static void main(String[] args) {
        //1.创建真是对象
        Lenovo lenovo=new Lenovo();

        //2.动态代理增强Lenovo对象
                SaleComputer proxy = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                        lenovo.getClass().getInterfaces(),
                        new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return null;
                    }
                });
    }
}
