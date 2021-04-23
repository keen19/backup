package DesignPattern.mediator;

public interface Colleague {

    Mediator getMediator();

    void  sendMessage(int stateChange);
}
