package sjms;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject{

    List<Observer> Observers=new ArrayList();

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
    void otherMethod(){

    }
}
