package com.javarush.task.task07.task0724;

/* 
Семейная перепись
Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей.
Вывести объекты на экран.

Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human human1 = new Human("Anton", true, 30);
        Human human2 = new Human("NeAnton", false, 31);
        Human human3 = new Human("TojeNeAnton", false, 32);
        Human human4 = new Human("Anton&Anton", true, 33);
        Human human5 = new Human("Avgusto", true, 33,human1, human2);
        Human human6 = new Human("Vivien", false, 22, human4, human3);
        Human human7 = new Human("Vinchenso", true, 11, human5, human6);
        Human human8 = new Human("Alexandra", true, 44, human5, human6);
        Human human9 = new Human("Antonina", false, 66, human5, human6);

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);
        System.out.println(human5);
        System.out.println(human6);
        System.out.println(human7);
        System.out.println(human8);
        System.out.println(human9);

    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















