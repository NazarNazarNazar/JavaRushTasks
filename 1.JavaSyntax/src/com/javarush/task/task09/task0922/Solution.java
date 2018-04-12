package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате "08/18/2013"
Вывести на экран эту дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ourDate = reader.readLine();

//        LocalDate date = LocalDate.parse(ourDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        System.out.println(date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy", new Locale("eng"))));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        SimpleDateFormat newSdf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = sdf.parse(ourDate);
        String result = newSdf.format(date).toUpperCase();
        System.out.println(result);
    }
}
