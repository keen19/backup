package DesignPattern.responsibilitychain;

public class Client {
    public static void main(String[] args) {
        //创建一个请求
        PurchseRequest purchseRequest = new PurchseRequest(1, 31000, 1);
        //创建所有审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("系主任");

        CollegeApprover collegeApprover = new CollegeApprover("院长");

        ViceMasterApprover viceMasterApprover = new ViceMasterApprover("副校长");

        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("校长");
        //设置各个审批级别的下一级别审批人
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceMasterApprover);
        viceMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(purchseRequest);
    }
}
