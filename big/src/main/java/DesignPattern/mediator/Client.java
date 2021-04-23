package DesignPattern.mediator;

public class Client {
    public static void main(String[] args) {
        Mediator  mediator = new ConceteMediator();
        Alarm alarm = new Alarm(mediator, "闹钟");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "咖啡机");
        Curtains curtains = new Curtains(mediator, "窗帘");
        TV tv = new TV(mediator, "电视机");
        alarm.sendAlarm(0);
        coffeeMachine.finishCoffee();
        alarm.sendAlarm(1);
    }
}
