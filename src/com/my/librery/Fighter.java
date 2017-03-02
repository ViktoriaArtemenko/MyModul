package com.my.librery;

public class Fighter extends Thread {

    private int endurance = 100;   //  выносливость - life
    private int strength;          //  сила
    private int dexterity;         //  ловкость
    private int intuition;         //  интуиция

    private Arena arena;
    private int number;

    public Fighter(int strength, int dexterity, int intuition, int number, Arena arena) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intuition = intuition;
        this.number = number;
        this.arena = arena;
    }

    @Override
    public void run() {
        start();
    }

    public int getResultStrength() {
        int result = strength;
        double divider = 100.0;
        synchronized (arena) {
            if (dexterity / divider > 0.5 && intuition / divider > 0.5) {
                result = result * 2;
            }
            arena.notify();
        }
        return result;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getNumber() {
        return number;
    }

    public void changeEndurance(int howMuch) {
        endurance -= howMuch;
    }
}
