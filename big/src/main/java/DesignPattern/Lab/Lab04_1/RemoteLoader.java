package DesignPattern.Lab.Lab04_1;

public class RemoteLoader {
    Command command;
    public RemoteLoader(){
        Command noComand=new NoCommand();
        command=noComand;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
    public void buttonWasPushed(){
        command.excute();
    }
    public void undoButtonWasPushed(){
        command.undo();
    }
}
