package DesignPattern.principle.ocp;

public class Client {
    public static void main(String[] args) {
        Driver driver = new Driver();
        DrivePlane drivePlane = new DrivePlane();
        driver.PeolpeDrive(drivePlane);
    }
}

abstract class Drive {
    public abstract void drive();
}

//提供方
class DriveCar extends Drive {

    @Override
    public void drive() {
        System.out.println("驾驶汽车");
    }
}

class DrivePlane extends Drive {

    @Override
    public void drive() {
        System.out.println("驾驶飞机");
    }
}

//使用方
class Driver {
    public void PeolpeDrive(Drive drive) {
        drive.drive();
    }
}
