package proxy;

public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花了800元买了一台联想电脑");
        return "联想电脑";
    }

    @Override
    public String show() {
        return null;
    }
}
