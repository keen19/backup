package DesignPattern.mediator;

public class Curtains implements Colleague {
    private Mediator mediator;
    private String name;
    public Curtains(Mediator mediator, String name) {
        this.mediator=mediator;
        this.name=name;
        mediator.register(name,this);
    }

    public void upCurtains(){
        System.out.println("拉起窗帘....");
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

