package DesignPattern.Obeserver;

public class Client {
    public static void main(String[] args) {
        //创建天气数据对象WeatherData
        WeatherData weatherData=new WeatherData();

        //创建观察者对象
        CurrentConditions currentConditions=new CurrentConditions();
        Baidu baidu = new Baidu();

        //注册到WeatherData,调用注册方法registerObserver()
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baidu);

        //输出
        System.out.println("通知注册的观察者");
        //写入天气数据
        weatherData.setData(10,100,20);
    }
}
