package DesignPattern.Obeserver;

/**
 * 观察者的实现类
 */

public class Baidu implements Observer {
    //温度 气压 湿度
    private double temperature;
    private double pressure;
    private double humidity;


    /**
     * 更新数据  并且显示数据调用display();
     * @param temperature
     * @param pressure
     * @param humidity
     */
    @Override
    public void update(double temperature, double pressure, double humidity) {
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }

    /**
     * 显示数据
     * 打印数据
     */
    public void display(){
        System.out.println("百度的温度:"+temperature);
        System.out.println("百度的气压:"+pressure);
        System.out.println("百度的湿度:"+humidity);
    }
}
