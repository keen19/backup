package DesignPattern.Obeserver;

public class Lab01 {
    public static void main(String[] args) {
        //创建天气数据对象WeatherData
        WeatherData weatherData=new WeatherData();

        //创建观察者对象
        CurrentConditions currentConditions=new CurrentConditions();

        //注册到WeatherData,调用注册方法registerObserver()
        weatherData.registerObserver(currentConditions);


        //写入天气数据
        weatherData.setData(10,100,20);
        weatherData.setData(20,90,15);
        weatherData.setData(25,95,25);
    }
}