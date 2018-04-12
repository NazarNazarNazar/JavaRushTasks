package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        while (reader.ready()){
            String [] s = reader.readLine().split(" ");
            for (String word:s) {
                Pattern p  = Pattern.compile("\\S*\\d+\\S*");
                Matcher m = p.matcher(word);
                if (m.find()){
                    writer.write(word+" ");
                    writer.flush();
                }
            }
        }
        reader.close();
        writer.close();
    }
}
