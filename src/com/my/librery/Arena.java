package com.my.librery;

import java.util.Observable;

public class Arena extends Observable {

    private String result;

    public String getResult() {
        return result;
    }

    public synchronized void notifyDisplay() {
        setChanged();
        notifyObservers();
    }

    public void battle(Fighter fighter_one, Fighter fighter_two) {
        if (fighter_one.getResultStrength() > fighter_two.getResultStrength()) {

            result = "Боец " + fighter_one.getNumber() + " + Боец " + fighter_two.getNumber()
                    + ": Победил боец №" + fighter_one.getNumber();
            fighter_two.changeEndurance(fighter_one.getEndurance());

        } else if (fighter_one.getResultStrength() < fighter_two.getResultStrength()) {

            result = "Боец " + fighter_one.getNumber() + " + Боец " + fighter_two.getNumber() +
                    ": Победил боец №" + fighter_two.getNumber();
            fighter_one.changeEndurance(fighter_two.getEndurance());

        } else {

            result = "Боец " + fighter_one.getNumber() + " + Боец " + fighter_two.getNumber() +
                    ": Ничья";

        }
    }
}
