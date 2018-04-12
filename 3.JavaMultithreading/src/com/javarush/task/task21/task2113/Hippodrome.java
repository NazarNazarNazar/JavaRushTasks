package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }
    public Hippodrome (List<Horse> horses) {
        this.horses = horses;
    }

    /*создаём методы для управления движения лошадей(move),
     отрисовки на экран(print), управлять всем этим(run)*/
    public void run () {
        for (int i = 0; i < 100 ; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move () {
       for(Horse x : horses) {
           x.move();
       }
    }
    public void print () {
        for(Horse x : horses) {
            x.print();
        }
        for (int i = 0; i < 10 ; i++) {
            System.out.println();
        }
    }
    public Horse getWinner() {
        double maxValue = 0;
        Horse winner = horses.get(0);
        for(Horse x : horses) {
            if(x.getDistance() > maxValue)
                maxValue = x.getDistance();
                winner = x;
        }

        return winner ;
    }
    public void printWinner() {
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
    public static void main(String[] args) {
//        List<Horse> stalionHorses = new ArrayList<>();
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Fucker",3.0, 0.0);
        Horse horse2 = new Horse("Sucker",3.0, 0.0);
        Horse horse3 = new Horse("MotherFucker",3.0, 0.0);
        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);


        game.run();
        game.printWinner();
    }
}
