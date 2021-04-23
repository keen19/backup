package XIANCHENG;

import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {
    @Override
    public void run(){
        Thread t=Thread.currentThread();
        System.out.println("Run() by"+t);
        System.out.println("eh"+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }

}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e){
        System.out.println("caught"+e);
    }
}
class HandlerThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r){
        System.out.println(this+"creating new Thread");
        Thread t=new Thread(r);
        System.out.println("creating"+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh="+t.getUncaughtExceptionHandler());
        return  t;
    }
}
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exe= Executors.newCachedThreadPool(new HandlerThreadFactory());
        exe.execute(new ExceptionThread2());
    }
}
