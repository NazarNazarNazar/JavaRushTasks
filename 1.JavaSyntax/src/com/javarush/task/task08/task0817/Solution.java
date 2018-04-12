package com.javarush.task.task08.task0817;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        map.put("Fomichova", "Lidiya");
        map.put("Ivanova", "Lidiydfa");
        map.put("Petrova", "Lidiaffa");
        map.put("Vaflova", "Lidiyafsf");
        map.put("Smirnova", "Lidiya");
        map.put("Durnova", "Lidiasdf");
        map.put("Korovna", "Lidiyffdvc");
        map.put("Fomich", "Lidiyacv");
        map.put("Fomenko", "Lidiyanh");
        map.put("Fomichidze", "Lidiyadhgn");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator();

        while (iterator.hasNext())
        {
            HashMap.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            iterator.remove();
            if(copy.containsValue(value))
                removeItemFromMapByValue(map, value);
        }



    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
