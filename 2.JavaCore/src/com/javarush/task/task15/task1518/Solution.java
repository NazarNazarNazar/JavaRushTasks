package com.javarush.task.task15.task1518;

/* 
Статики и котики
1. В классе Solution создай класс Cat с публичным полем name типа String.
2. В статическом блоке создай объект типа Cat и присвой его переменной cat(не забудь инициализировать поле name).
3. В классе Cat не создавай конструкторы с параметрами.
4. В статическом блоке выведи имя созданного кота на экран.
*/

public class Solution {
    static{
        Cat cattttt = new Cat();
        cat = cattttt;
        cattttt.name = "baksik";
        System.out.println(cattttt.name);
    }

    public static class Cat {
        public String name;
    }


    public static Cat cat;

    public static void main(String[] args) {

    }
}
