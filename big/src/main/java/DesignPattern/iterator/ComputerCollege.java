package DesignPattern.iterator;

import java.util.Iterator;

//计算机学院
public class ComputerCollege implements College {
    //创建一个放 系类 的数组
    Department[] departments;
    //索引,保存当前数组的对象个数,
    private int numOfDepartment=0;

    //构造器
    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("JAVA专业","JAVA专业");
        addDepartment("PHP专业","PHP专业");
        addDepartment("PYTHON专业","PYTHON专业");
    }

    //重写接口方法
    @Override
    public String getName() {
        return "计算机学院";
    }

    //增加一个系
    @Override
    public void addDepartment(String name, String desc) {
        //创建一个系对象
        Department department = new Department(name, desc);
        //把系对象放入系对象数组departments
        departments[numOfDepartment]=department;
        //数组个数+1
        numOfDepartment +=1;
    }

    //返回一个对应的迭代器
    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
