package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human children1 = new Human("Vasek", true,11, new ArrayList<Human>());
        Human children2 = new Human("Basilio", false, 20, new ArrayList<Human>());
        Human children3 = new Human("Ambrosio", true, 21, new ArrayList<Human>());
        ArrayList<Human> children = new ArrayList<>();
        children.add(children1);
        children.add(children2);
        children.add(children3);

        Human mother = new Human("Zinaida", false, 44, children);
        Human father = new Human("Inakentiy", true, 50, children);
        ArrayList<Human> parents1 = new ArrayList<Human>();
        ArrayList<Human> parents2 = new ArrayList<Human>();
        parents1.add(mother);
        parents2.add(father);

        Human grandFather1 = new Human("Demian", true, 77, parents1);
        Human grandFather2 = new Human("Ashton", true, 88, parents2);
        Human grandmother1 = new Human("Klavdia", false, 55, parents1);
        Human grandmother2 = new Human("Glafera", false, 56, parents2);

        ArrayList<Human> grand = new ArrayList<Human>();
        grand.add(grandFather1);
        grand.add(grandFather2);
        grand.add(grandmother1);
        grand.add(grandmother2);
        grand.add(father);
        grand.add(mother);
        grand.add(children1);
        grand.add(children2);
        grand.add(children3);

        for(Human x : grand)
        {
            System.out.println(x.toString());
        }
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human (String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
