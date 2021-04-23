package DesignPattern.visitor;

public class CEOVisiter implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师:"+engineer.name+",KPI"+engineer.kpi+",代码量"+engineer.getCodeCount());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理:"+manager.name+",KPI"+manager.kpi+",产品:"+manager.getProducts());
    }
}
