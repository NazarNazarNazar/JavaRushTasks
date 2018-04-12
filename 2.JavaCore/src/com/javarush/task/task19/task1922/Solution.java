package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));

        while (fr.ready()){
            String temp = fr.readLine();
            String[] strMas = temp.split("[\\p{Punct}\\s\\t\\n\\r]");
            int counter = 0;

            ////вот здесь вся разница
            for (String s : strMas){
                if (words.contains(s)) counter++;
            }
            if (counter == 2) System.out.println(temp);
        }
        br.close();
        fr.close();
    }
}
