package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        reader.close();

        BufferedReader rd = new BufferedReader(new FileReader(str1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(str2));
        String text ="";
        while (rd.ready()) {
            String[] buffer = rd.readLine().split(" ");
            for(String x : buffer) {
                if(x.matches("\\b\\d+\\b"))
                    bw.write(x+" ");
            }

        }
        rd.close();
        bw.close();
    }
}
