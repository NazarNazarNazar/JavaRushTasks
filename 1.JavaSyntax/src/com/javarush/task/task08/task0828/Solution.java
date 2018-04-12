package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is 5 month".
Используйте коллекции.
*/

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> list = new HashMap<>();
        list.put("January", "January is 1 month");
        list.put("February", "February is 2 month");
        list.put("March", "March is 3 month");
        list.put("April", "April is 4 month");
        list.put("May", "May is 5 month");
        list.put("June", "June is 6 month");
        list.put("July", "July is 7 month");
        list.put("August", "August is 8 month");
        list.put("September", "September is 9 month");
        list.put("October", "October is 10 month");
        list.put("November", "November is 11 month");
        list.put("December", "December is 12 month");

        Iterator<Map.Entry<String, String>> iterator = list.entrySet().iterator();
        String month = reader.readLine();
        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String monthMap = pair.getValue();
            String monthKey = pair.getKey();
            if(month.equals(monthKey))
                System.out.println(monthMap);

        }



//        SimpleDateFormat sDF = new SimpleDateFormat("MMMM", Locale.ENGLISH);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(sDF.parse(month));
//        System.out.println(month+" is " +(calendar.get(Calendar.MONTH)+1)+ " month");
    }
}
