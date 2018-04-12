package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private boolean sex;
        private int age;
        private long monyCount;
        private ArrayList<Human> animals;
        private String mistress;

        public Human (String name){
            this.name = name;
        }
        public Human (String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human (String name, int age) {
            this.name = name;
            this.age = age;
        }
        public Human (String name, boolean sex, int age, long monyCount) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.monyCount = monyCount;
        }
        public Human (String name, boolean sex, int age, long monyCount, ArrayList<Human> animals) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.monyCount = monyCount;
            this.animals = animals;
        }
        public Human (String name, boolean sex, int age, long monyCount, ArrayList<Human> animals, String mistress) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.monyCount = monyCount;
            this.animals = animals;
            this.mistress = mistress;
        }
        public Human (String name, boolean sex, int age, long monyCount, String mistress) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.monyCount = monyCount;
            this.mistress = mistress;
        }
        public Human (String name, boolean sex, long monyCount, ArrayList<Human> animals, String mistress) {
            this.name = name;
            this.sex = sex;
            this.monyCount = monyCount;
            this.animals = animals;
            this.mistress = mistress;
        }
        public Human (String name, boolean sex, int age, ArrayList<Human> animals, String mistress) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.animals = animals;
            this.mistress = mistress;
        }
    }
}
