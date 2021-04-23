package DesignPattern.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {
    //信息工程学院以List方式存放系
    List<Department> departmentList;
    int index = -1;//索引

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    //判断list中还有没有下一个元素
    @Override
    public boolean hasNext() {
        if (index < (departmentList.size() - 1)) {
            index += 1;
            return true;
        } else {

            return false;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    @Override
    public void remove() {

    }
}
