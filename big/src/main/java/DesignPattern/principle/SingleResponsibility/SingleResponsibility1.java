package DesignPattern.principle.SingleResponsibility;

public class SingleResponsibility1 {
    public static void main(String[] args) {
        WaterVehicle waterVehicle = new WaterVehicle();
        AirVehicle airVehicle = new AirVehicle();
        waterVehicle.run("船");
        airVehicle.run("飞机");

    }
}
class WaterVehicle{
    public void run(String Vehicle){
        System.out.println(Vehicle+"在海上行驶");
    }
        }
class AirVehicle{
    public void run(String Vehicle){
        System.out.println(Vehicle+"在天上行驶");
    }
}
