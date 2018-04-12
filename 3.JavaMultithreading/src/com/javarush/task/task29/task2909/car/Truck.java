package com.javarush.task.task29.task2909.car;

public class Truck extends Car {
    public static final int MAX_TRUCK_SPEED = 80;

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }

    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }
}
