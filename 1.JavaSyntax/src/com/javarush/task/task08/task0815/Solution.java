package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Petro");
        map.put("Sidoriv", "Sidor");
        map.put("Shuprutko", "Denis");
        map.put("Mudakov", "Mudak");
        map.put("Jaldybay", "Jaldybaiy");
        map.put("Krut", "Lesha");
        map.put("Putin", "Vladimir");
        map.put("Nazarbaev", "Nusrultan");
        map.put("Masimov", "Ivan");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int numberOfPeople = 0;
        for(String x : map.values()){
            if(x.equals(name))
                numberOfPeople++;
        }

        return numberOfPeople;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int numberOfLastName = 0;

        for(String x : map.keySet()) {
            if(x.equals(lastName))
                numberOfLastName++;
        }


        return numberOfLastName;
    }

    public static void main(String[] args) {

    }
}
