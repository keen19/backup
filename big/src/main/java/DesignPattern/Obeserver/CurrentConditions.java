package DesignPattern.Obeserver;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者的实现类
 */

public class CurrentConditions implements Observer{
    //温度 气压 湿度
    private List<Double> temperature=new ArrayList<>();
    private List<Double> pressure=new ArrayList<>();
    private List<Double> humidity=new ArrayList<>();


    /**
     * 更新数据  并且显示数据调用display();
     * @param temperature
     * @param pressure
     * @param humidity
     */
    @Override
    public void update(double temperature, double pressure, double humidity) {
        this.temperature.add(temperature);
        this.pressure.add(pressure);
        this.humidity.add(humidity);
        display();
        diplay1();
    }

    /**
     * 显示数据
     * 打印数据
     */
    public void display(){//输出
        System.out.println("目前状况:");
        System.out.println("温度:"+temperature.get(temperature.size()-1));
        System.out.println("气压:"+pressure.get(pressure.size()-1));
        System.out.println("湿度:"+humidity.get(humidity.size()-1));
        System.out.println("================================");

    }
    public void diplay1(){
        Double avgTemperature=0.;
        Double avgPressure=0.;
        Double avgHumidity=0.;
        for (int i = 0; i <temperature.size() ; i++) {
             avgTemperature=avgTemperature+ temperature.get(i);
             avgPressure=avgPressure+pressure.get(i);
             avgHumidity=avgHumidity+humidity.get(i);
        }
        System.out.println("天气统计:");
        System.out.println("平均温度:"+avgTemperature/temperature.size());
        System.out.println("平均气压:"+avgPressure/pressure.size());
        System.out.println("平均湿度:"+avgHumidity/humidity.size());
        System.out.println("================================");
    }
}
