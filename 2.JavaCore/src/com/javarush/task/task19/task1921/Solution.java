package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));

        while (br.ready()) {
            String fullString = br.readLine();
            String stringName = fullString.replaceAll("\\d", "").trim();
            String stringDate = fullString.substring(stringName.length() + 1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.US);
            PEOPLE.add(new Person(stringName, sdf.parse(stringDate)));
        }

        br.close();
    }
}
