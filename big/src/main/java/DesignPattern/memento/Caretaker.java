package DesignPattern.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    //在List 集合保存备忘录对象
    private List<Memento> mementoList=new ArrayList<>();

    //增加一个memento对象到List
    public void add(Memento memento) {
        mementoList.add(memento);
    }

    //获取第index个Originator的备忘录对象
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
