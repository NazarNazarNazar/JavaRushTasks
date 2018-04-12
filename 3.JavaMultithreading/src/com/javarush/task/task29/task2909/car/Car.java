package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case TRUCK:
                return new Truck(numberOfPassengers);
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            default:
                return null;
        }
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    private boolean canPassengersBeTransferred() {
            return driverAvailable && fuel > 0;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
            fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return (date.before(summerEnd) && date.after(summerStart));
    }

    public double getWinterConsumption(int length) {
        return winterWarmingUp + winterFuelConsumption * length;
    }

    public double getSummerConsumption(int length) {
        return summerFuelConsumption * length;
    }

    //    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
//        double consumption;
//        if (date.before(SummerStart) || date.after(SummerEnd)) {
//            consumption = length * winterFuelConsumption + winterWarmingUp;
//        } else {
//            consumption = length * summerFuelConsumption;
//        }
//        return consumption;
//    }
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date, SummerStart, SummerEnd)) {
            return getSummerConsumption(length);
        }
        else {
            return getWinterConsumption(length);
        }
    }

    public int getNumberOfPassengersCanBeTransferred() {
//        if (!isDriverAvailable())
//            return 0;
//        if (fuel <= 0)
//            return 0;
        if(!canPassengersBeTransferred())
            return 0;
            return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}