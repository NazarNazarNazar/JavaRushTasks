package com.javarush.task.task08.task0827;

import java.lang.management.MemoryManagerMXBean;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
    если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date(date)); можно и без форматирования даты
        calendar.setTime(format.parse(date)); // с SimpleDateFormat более универсальное решение
        return calendar.get(Calendar.DAY_OF_YEAR) % 2 != 0;
    }
}
