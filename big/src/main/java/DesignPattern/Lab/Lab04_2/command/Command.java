package DesignPattern.Lab.Lab04_2.command;

public interface Command {
    //执行动作
     void execute();

    //撤销动作
    void undo();
}
