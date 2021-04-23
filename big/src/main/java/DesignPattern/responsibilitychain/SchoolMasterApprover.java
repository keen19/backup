package DesignPattern.responsibilitychain;

public class SchoolMasterApprover extends Approver {
    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchseRequest purchseRequest) {
        if (purchseRequest.getPrice() > 30000) {
            System.out.println("请求编号:    " + purchseRequest.getId() + "    处理");
        } else {
            approver.processRequest(purchseRequest);
        }
    }
}
