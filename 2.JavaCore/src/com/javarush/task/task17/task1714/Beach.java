package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("b1", 100, 5);
        Beach beach2 = new Beach("b2", 101, 4);

        int i = beach1.compareTo(beach2);
        // узнаем сравнением beach1 К beach2

        System.out.println(i);
    }

    @Override
    public synchronized int compareTo(Beach o) {
        return (int) ((this.quality*this.distance)-(o.getQuality()*o.getDistance()));
    }
}
