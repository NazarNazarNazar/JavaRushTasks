package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<>();
        map.put("Cat1", new Cat("Murzik"));
        map.put("Cat2", new Cat("Murziasfk"));
        map.put("Cat3", new Cat("Murzikaf"));
        map.put("Cat4", new Cat("Murzasfik"));
        map.put("Cat5", new Cat("Murzirk"));
        map.put("Cat6", new Cat("Murzikki"));
        map.put("Cat7", new Cat("Mukmjrzik"));
        map.put("Cat8", new Cat("Murzihdjyk"));
        map.put("Cat9", new Cat("Murzikwewq"));
        map.put("Cat10", new Cat("Murzikiyuk"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> set = new HashSet<>();
        for(Map.Entry<String, Cat> pair : map.entrySet())
        {
            Cat value = pair.getValue();
            set.add(value);
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
