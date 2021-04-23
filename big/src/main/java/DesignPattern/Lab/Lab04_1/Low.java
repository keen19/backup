package DesignPattern.Lab.Lab04_1;

public class Low implements Command {
    DiaoShan diaoShan;
    int preSpeed;
    public Low(DiaoShan diaoShan){
        this.diaoShan=diaoShan;
    }
    @Override
    public void excute() {
        preSpeed=diaoShan.getSwitchspeed();
        diaoShan.low();
    }

    @Override
    public void undo() {
        if (preSpeed==DiaoShan.HIGH){
            diaoShan.high();
        }else if (preSpeed==DiaoShan.MEDIUM) {
            diaoShan.medium();
        }else if (preSpeed==DiaoShan.LOW) {
            diaoShan.low();
        }else if (preSpeed==DiaoShan.OFF) {
            diaoShan.off();
        }
    }
}
