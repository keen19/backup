package DesignPattern.responsibilitychain;

public class CollegeApprover extends Approver {
    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchseRequest purchseRequest) {
        if (purchseRequest.getPrice() > 5000 && purchseRequest.getPrice() <= 10000) {
            System.out.println("请求编号:    " + purchseRequest.getId() + "    处理");
        } else {
            approver.processRequest(purchseRequest);
        }
    }
}
