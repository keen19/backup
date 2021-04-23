package DesignPattern.visitor;

public class Client {
    public static void main(String[] args) {
        BusinessReport report=new BusinessReport();
        System.out.println("=====");
        report.showReport(new CEOVisiter());
    }
}
