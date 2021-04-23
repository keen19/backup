package DesignPattern.composite;

//专业
public class Department extends OrganizationComponent {
    //专业没有下一级所有没有List
    public Department(String name, String description) {
        super(name, description);
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}
