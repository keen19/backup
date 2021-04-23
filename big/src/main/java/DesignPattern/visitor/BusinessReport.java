package DesignPattern.visitor;

import java.util.LinkedList;
import java.util.List;

public class BusinessReport {
    private List<Staff> staffs=new LinkedList<>();
    public BusinessReport(){
        staffs.add(new Manager("经理A"));
        staffs.add(new Manager("经理B"));
        staffs.add(new Engineer("工程师A"));
        staffs.add(new Engineer("工程师B"));
        staffs.add(new Engineer("工程师C"));
        staffs.add(new Manager("经理C"));
        staffs.add(new Engineer("工程师D"));
    }

    public void showReport(Visitor visitor){
        for (Staff staff : staffs) {
            staff.accept(visitor);
        }
    }
}
