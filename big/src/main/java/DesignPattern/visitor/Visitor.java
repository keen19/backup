package DesignPattern.visitor;

//访问者接口
public interface Visitor {
    void visit(Engineer engineer);
    void visit(Manager manager);
}
