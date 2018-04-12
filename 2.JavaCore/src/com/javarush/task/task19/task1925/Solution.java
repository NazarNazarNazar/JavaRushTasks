package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);

        String input = "";
        String output = "";

        while(reader.ready()){
            input += reader.readLine()+" ";
        }
        input.trim();
        String[] data = input.split(" ");
        for (int i = 0; i < data.length ; i++) {
            if(data[i].length() > 6)
                output += data[i] +",";
        }
        output = output.substring(0, output.length()-1);
        fileWriter.write(output);
        fileWriter.flush();
        reader.close();
        fileWriter.close();
    }
}
