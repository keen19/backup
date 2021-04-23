package DesignPattern.Lab.Lab02_1;

public abstract class Drink {
    public String des;
    private double price;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public abstract double cost();
}
