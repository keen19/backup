package DesignPattern.mediator;

public class TV implements Colleague {
    private Mediator mediator;
    private String name;
    public TV(Mediator mediator, String name) {
        this.mediator=mediator;
        this.name=name;
        mediator.register(name,this);
    }

    public void startTV(){
        System.out.println("打开电视机....");
    }

    public void stopTV(){
        System.out.println("关闭电视机....");
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

