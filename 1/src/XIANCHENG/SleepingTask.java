package XIANCHENG;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    @Override
    public void run(){
        try {
            while (countDown-- >0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService es= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new SleepingTask());
        }
        es.shutdown();
    }
}
