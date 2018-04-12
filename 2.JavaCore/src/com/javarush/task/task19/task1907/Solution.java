package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(reader.readLine());

        reader.close();

        String text = "";

        while (fileReader.ready())
            text += Character.toString((char) fileReader.read());

        String[] textArray = text.split("[\\W]");

        int counter = 0;
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i].equals("world"))
                counter++;
        }

        fileReader.close();

        System.out.println(counter);
    }
}
