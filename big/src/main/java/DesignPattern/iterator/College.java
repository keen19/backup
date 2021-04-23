package DesignPattern.iterator;

import java.util.Iterator;

/**
 * 学院接口
 */
public interface College {
    String getName();

    //增加系的方法
    void addDepartment(String name ,String desc);

    //返回一个遍历器,遍历
    Iterator createIterator();
}
