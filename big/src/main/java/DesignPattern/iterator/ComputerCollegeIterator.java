package DesignPattern.iterator;

import java.util.Iterator;

//计算机学院迭代器
public class ComputerCollegeIterator implements Iterator {
    //这里我们需要Department存放方式
    Department[] departments;
    //遍历位置
    int position =0;

    //构造器 传入一个 系对象 ,放入 系对象数组
    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    //判断下一个位置是否为空
    @Override
    public boolean hasNext() {
        if (position >= departments.length || departments[position] == null) {
            return false;
        }else {
            return true;
        }

    }

    //把数据取出 然后位置往后移动一位
    @Override
    public Object next() {
        Department department = departments[position];
        position +=1;
        return department;
    }

    @Override
    public void remove() {

    }
}
