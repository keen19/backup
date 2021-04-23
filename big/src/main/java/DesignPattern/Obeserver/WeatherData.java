package DesignPattern.Obeserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private double temperature;
    private double pressure;
    private double humidity;
    //观察者集合
    private List<Observer> observers=null;

    public WeatherData(){
        observers=new ArrayList<>();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * 当数据改变时调用notifyObservers()通知所有观察者
     */
    public void dataChange(){
        notifyObservers();
    }

    /**
     * 更新数据 并调用dataChange()
     * @param temperature
     * @param pressure
     * @param humidity
     */
    public void setData(double temperature,double pressure,double humidity){
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        dataChange();
    }


    //注册观察者
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    //删除观察者
    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)){
        observers.remove(observer);
        }
    }

    /**
     * 通知所有观察者
     *
     * observers.get(i).update(temperature,pressure,humidity);
     * 观察者调用自己的更新数据方法update()
     */
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(temperature,pressure,humidity);
        }
    }
}
