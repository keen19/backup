package DesignPattern.Lab.Lab04_1;

public class Clien {
    public static void main(String[] args) {
        DiaoShan diaoShan=new DiaoShan();
        FanOffComand fanOffComand = new FanOffComand(diaoShan);
        High high=new High(diaoShan);
        Low low=new Low(diaoShan);
        Medium medium=new Medium(diaoShan);
        RemoteLoader rl=new RemoteLoader();
        rl.setCommand(medium);
        rl.buttonWasPushed();
        rl.setCommand(fanOffComand);
        rl.buttonWasPushed();
        rl.setCommand(high);
        rl.buttonWasPushed();
        rl.setCommand(fanOffComand);
        rl.buttonWasPushed();
    }
}
