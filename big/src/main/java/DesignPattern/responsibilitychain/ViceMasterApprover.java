package DesignPattern.responsibilitychain;

public class ViceMasterApprover extends Approver {
    public ViceMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchseRequest purchseRequest) {
        if (purchseRequest.getPrice() > 10000 && purchseRequest.getPrice() <= 20000) {
            System.out.println("请求编号:    " + purchseRequest.getId() + "    处理");
        } else {
            approver.processRequest(purchseRequest);
        }
    }
}
