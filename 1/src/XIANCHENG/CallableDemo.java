package XIANCHENG;


import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id=id;
    }
    @Override
    public String call(){
        return "result of TaskWithResult"+id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exes= Executors.newCachedThreadPool();
        ArrayList<Future<String>> results=new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exes.submit(new TaskWithResult(i)));}
            for(Future<String> fs:results){
                try{
                    System.out.println(fs.get());
                }catch (InterruptedException e){
                    System.out.println(e);
                    return;
                }catch (ExecutionException e){
                    System.out.println(e);
                }finally {
                    exes.shutdown();
                }
            }
        }

}
