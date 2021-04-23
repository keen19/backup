package DesignPattern.composite;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationComponent {

    List<OrganizationComponent> organizationComponents=new ArrayList<>();

    //构造器
    public University(String name, String description) {
        super(name, description);
    }

    //重写add
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    //重写remove

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

//    @Override
//    public String getName() {
//        return super.getName();
//    }
//
//    @Override
//    public String getDescription() {
//        return super.getDescription();
//    }

    @Override
    protected void print() {
        System.out.println("-------"+getName()+"-------");
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}
