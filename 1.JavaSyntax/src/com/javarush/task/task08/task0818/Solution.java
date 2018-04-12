package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Banderos", 2000);
        map.put("Banderoafas", 600);
        map.put("Bandeasfros", 70);
        map.put("Bandasfaeros", 1000);
        map.put("Baasfasnderos", 6000);
        map.put("Banderocvs", 20001);
        map.put("Banderosmjfm", 20);
        map.put("Bgfnnbdanderos", 500);
        map.put("Babsbsdnderos", 20000);
        map.put("Bandesdbros", 200000);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            HashMap.Entry<String, Integer> pair = iterator.next();
            Integer value = pair.getValue();
            if(value < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}