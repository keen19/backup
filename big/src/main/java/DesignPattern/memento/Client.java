package DesignPattern.memento;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        //创建一个originator状态#1
        originator.setState("状态#1");
        //originator状态#1添加到caretaker
        caretaker.add(originator.saveStateMemento());
        //创建一个originator状态#2
        originator.setState("状态#2");
        caretaker.add(originator.saveStateMemento());
        //originator状态#2添加到caretaker
        System.out.println("当前的状态"+originator.getState());
        //恢复到状态#1
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("当前的状态"+originator.getState());

    }
}
