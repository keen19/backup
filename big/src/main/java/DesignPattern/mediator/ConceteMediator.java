package DesignPattern.mediator;

import java.util.HashMap;

public class ConceteMediator implements Mediator {
    private HashMap<String, Colleague> colleagueHashMap;
    private HashMap<String, String> interMap;

    public ConceteMediator() {
        colleagueHashMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueHashMap.put(colleagueName, colleague);

        if (colleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        } else if (colleague instanceof CoffeeMachine) {
            interMap.put("CoffeeMachine", colleagueName);
        }else if (colleague instanceof TV) {
            interMap.put("TV", colleagueName);
        }else if (colleague instanceof Curtains) {
            interMap.put("Curtains", colleagueName);
        }
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        if (colleagueHashMap.get(colleagueName) instanceof Alarm){
            if (stateChange == 0) {
                ((CoffeeMachine)(colleagueHashMap.get(interMap
                        .get("CoffeeMachine")))).startCoffee();
                ((TV)(colleagueHashMap.get(interMap.get("TV")))).startTV();
            } else if (stateChange == 1) {
                ((TV)(colleagueHashMap.get(interMap.get("TV")))).stopTV();
            }
        }else if (colleagueHashMap.get(colleagueName) instanceof CoffeeMachine) {
                ((Curtains)(colleagueHashMap.
                        get(interMap.get("Curtains")))).upCurtains();
            } else if (colleagueHashMap.get(colleagueName) instanceof TV) {

            }else if (colleagueHashMap.get(colleagueName) instanceof Curtains) {

        }

    }

    @Override
    public void sendMessage() {

    }
}
