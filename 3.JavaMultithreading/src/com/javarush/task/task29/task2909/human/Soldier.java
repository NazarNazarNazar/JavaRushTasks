package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

//    @Override
//    public void setBloodGroup(int code) {
//        super.setBloodGroup(code);
//    }
//
//    @Override
//    public int getBloodGroup() {
//        return super.getBloodGroup();
//    }


    @Override
    public BloodGroup getBloodGroup() {
        return super.getBloodGroup();
    }

    @Override
    public void setBloodGroup(BloodGroup bloodGroup) {
        super.setBloodGroup(bloodGroup);
    }

    @Override
    public void live() {
        fight();
    }

    public void fight() {

    }
}
