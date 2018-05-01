package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* 
Работа с датами
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов) и выводить ее в консоль в соответствии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 1
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 4
Год: 2014
AM или PM: PM
Часы: 3
Часы дня: 15
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 1
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 4
Год: 2014

3) Для "17:33:40":
AM или PM: PM
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        try {
            if (date.contains(" ")) {
                dateAndTime(date);
            } else if (date.contains(".")) {
                time(date);
            } else if (date.contains(":")) {
                hourMinSec(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void hourMinSec(String date) throws ParseException {
        Locale locale = new Locale("ru");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", locale);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFormat.parse(date));

        String ampm;
        if (cal.get(Calendar.AM_PM) == 1) {
            ampm = "PM";
        } else ampm = "AM";

        System.out.println("AM или PM: " + ampm);
        System.out.println("Часы: " + cal.get(Calendar.HOUR));
        System.out.println("Часы дня: " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + cal.get(Calendar.MINUTE));
        System.out.println("Секунды: " + cal.get(Calendar.SECOND));
    }

    public static void time(String date) throws ParseException {
        Locale locale = new Locale("ru");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", locale);
        cal.setTime(dateFormat.parse(date));
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        int month = cal.get(Calendar.MONTH) + 1;

        System.out.println("День: " + cal.get(Calendar.DATE));
        System.out.println("День недели: " + dayOfWeek);
        System.out.println("День месяца: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + cal.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + month);
        System.out.println("Год: " + cal.get(Calendar.YEAR));
    }

    public static void dateAndTime(String date) throws ParseException {
        Locale locale = new Locale("ru");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", locale);
        cal.setTime(dateFormat.parse(date));

        String ampm;
        if (cal.get(Calendar.AM_PM) == 1) {
            ampm = "PM";
        } else ampm = "AM";


        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        int month = cal.get(Calendar.MONTH) + 1;

        System.out.println("День: " + cal.get(Calendar.DATE));
        System.out.println("День недели: " + dayOfWeek);
        System.out.println("День месяца: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + cal.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + month);
        System.out.println("Год: " + cal.get(Calendar.YEAR));
        System.out.println("AM или PM: " + ampm);
        System.out.println("Часы: " + cal.get(Calendar.HOUR));
        System.out.println("Часы дня: " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + cal.get(Calendar.MINUTE));
        System.out.println("Секунды: " + cal.get(Calendar.SECOND));
    }
}
