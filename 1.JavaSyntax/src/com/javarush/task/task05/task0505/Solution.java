package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat1 = new Cat("Murzik",3,4,88);
        Cat cat2 = new Cat("Rizik",2,5,77);
        Cat cat3 = new Cat("Fuzzy",1,7,66);

        if(cat1.fight(cat2))
        System.out.println(cat2);
        else System.out.println(cat1);

        if(cat2.fight(cat3))
        System.out.println(cat3);
        else System.out.println(cat2);

        if(cat3.fight(cat1))
        System.out.println(cat1);
        else System.out.println(cat3);
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
