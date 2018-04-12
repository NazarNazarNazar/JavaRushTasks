package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
1. Создай классы Dog, Cat и Mouse.
2. Реализуй интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution {
    public static void main(String[] args) {

    }
    public class Dog implements Movable, Eat{

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }
    public class Cat implements Movable, Eat, Eatable{

        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }

        @Override
        public void eat() {

        }
    }
    public class Mouse implements Movable, Eatable{

        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }
    }

    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }
}