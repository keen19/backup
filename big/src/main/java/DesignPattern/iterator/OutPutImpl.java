package DesignPattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutPutImpl {
    //学院集合
    List<College> collegeList=new ArrayList<>();

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }
    //遍历所有学院,然后调用printDepartment 输出所有系
    public void printCollege(){
        //从collegeList取出所有学院
        Iterator<College> iterator=collegeList.iterator();
        while (iterator.hasNext()){
            //取出一个学院
            College college=iterator.next();
            System.out.println("======" + college.getName() + "======");
            //
            printDepartment(college.createIterator());
        }
    }

    //输出学院 输出 系
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department d= (Department) iterator.next();
            System.out.println(d.getName());
        }
    }
}
