package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
Есть public интерфейсы Fly(летать), Move(передвигаться), Eat(есть).
Добавь эти интерфейсы классам Dog(собака), Car(автомобиль), Duck(утка), Airplane(самолет).
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Move {
        public void move();
    }

    public interface Eat {
        public void eat();
    }

    public class Dog implements Move, Eat {
        @Override
        public void move() {
            System.out.println("move");
        }

        @Override
        public void eat() {
            System.out.println("devour");
        }
    }

    public class Duck implements Move, Fly, Eat {
        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    public class Car implements Move {
        @Override
        public void move() {
            System.out.println("moving car");
        }
    }

    public class Airplane implements Move, Fly {
        @Override
        public void move() {
            System.out.println("airstrip");
        }
        @Override
        public void fly() {
            System.out.println("auejai");
        }
    }
}
