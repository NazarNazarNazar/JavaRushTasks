package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", new Date("June 1 1980"));
        map.put("Shvarc", new Date("July 1 1983"));
        map.put("Uilis", new Date("September 5 1990"));
        map.put("Lundgren", new Date("August 11 1988"));
        map.put("Mironov", new Date("December 3 2000"));
        map.put("Mkrtchan", new Date("November 30 1999"));
        map.put("Shurik", new Date("July 2 1981"));
        map.put("Stalion", new Date("October 12 1987"));
        map.put("Straustrup", new Date("February 1 1982"));
        map.put("Ekkel", new Date("June 1 1989"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        int month;
        Map.Entry<String, Date> pair;
        while (iterator.hasNext()){
            pair = iterator.next();
            month = pair.getValue().getMonth();
            if (month > 4 && month < 8)
            iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}
