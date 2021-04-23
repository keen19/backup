package DesignPattern.Lab.Lab04_2.command;

public class RemoteController {
    //开按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;

    //撤销的命令
    Command undoCommand;

    //构造器
    public RemoteController(){
        //添加5个按钮
        onCommands=new Command[5];
        offCommands=new Command[5];

        //给每个按钮初始化
        for (int i = 0; i < 5; i++) {
            onCommands[i]=new NoCommand();
            offCommands[i]=new NoCommand();
        }
    }

    //给我们的按钮设置需要的命令
    public void setCommand(int no, Command oncommand, Command offcommand) {
        onCommands[no] =oncommand;
        offCommands[no] =offcommand;
    }

    //按下开按钮
    public void onButtonWasPushed(int no) {
        //找到你按下的开的按钮,并执行
        onCommands[no].execute();
        //记录这次的操作,用于撤销
        undoCommand=onCommands[no];
    }
    //按下关按钮
    public void offButtonWasPushed(int no) {
        //找到你按下的开的按钮,并执行
        offCommands[no].execute();
        //记录这次的操作,用于撤销
        undoCommand=offCommands[no];
    }
    //按下撤销按钮
    public void undoButtonWasPusher(){
        undoCommand.undo();
    }
}
