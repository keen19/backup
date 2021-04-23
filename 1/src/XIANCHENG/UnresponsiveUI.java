package XIANCHENG;

class ResponsiveUI{
    private volatile double d=1;
    public ResponsiveUI() throws Exception{
        while (d>0){
            d=d+(Math.PI+Math.E)/d;
        }
    }
}
public class UnresponsiveUI extends Thread{
        private static volatile double d=1;
        public UnresponsiveUI(){
            setDaemon(true);
            start();
        }
        public void run(){
            while (true){
                d=d+(Math.PI+Math.E)/d;
            }
        }

    public static void main(String[] args) throws Exception{
        new UnresponsiveUI();
        System.in.read();
        System.out.println(d);
    }

}
