package DesignPattern.composite;

public class Client {
    public static void main(String[] args) {
        //从小到大创建对象 学校
        OrganizationComponent university = new University("清华大学", "顶级学校");

        //创建学院
        OrganizationComponent computerCollege = new College("计算机学院", "计算机学院");

        //创建专业
        OrganizationComponent software=new Department("软件工程","秃头专业");

        //添加学院
        university.add(computerCollege);
        //添加专业
        computerCollege.add(software);

        university.print();
    }
}
