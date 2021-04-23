package DesignPattern.mediator;

public class CoffeeMachine implements Colleague {
    private Mediator mediator;
    private String name;
    public CoffeeMachine(Mediator mediator, String name) {
        this.mediator=mediator;
        this.name=name;
        mediator.register(name,this);
    }

    public void startCoffee(){
        System.out.println("打开咖啡机....");
    }

    public void finishCoffee(){
        System.out.println("等待5分钟 完成!");
        System.out.println("咖啡 完成!");
        sendMessage(0);
    }
    public void stopCoffee(){
        System.out.println("关闭咖啡机");
    }

    @Override
    public Mediator getMediator() {
        return mediator;
    }

    @Override
    public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange,name);
    }
}

