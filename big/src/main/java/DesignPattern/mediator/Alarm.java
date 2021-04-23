package DesignPattern.mediator;

public class Alarm implements Colleague {
    private Mediator mediator;
    private String name;
    public Alarm(Mediator mediator, String name) {
        this.mediator=mediator;
        this.name=name;
        mediator.register(name,this);
    }

    public void sendAlarm(int stateChange){
        System.out.println("闹钟响起....");
        sendMessage(stateChange);
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
