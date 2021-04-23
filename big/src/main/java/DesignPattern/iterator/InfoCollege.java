package DesignPattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {
    List<Department> departmentList;


    public InfoCollege() {
        departmentList=new ArrayList<>();
        addDepartment("信息安全专业","信息安全专业");
        addDepartment("网络安全专业","网络安全专业");
        addDepartment("服务器安全专业","服务器安全专业");

    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    //增加一个系
    @Override
    public void addDepartment(String name, String desc) {
        //创建一个系对象
        Department department = new Department(name, desc);
        departmentList.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}

