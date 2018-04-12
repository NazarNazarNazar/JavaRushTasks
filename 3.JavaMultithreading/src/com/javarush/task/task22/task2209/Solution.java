package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //...
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String filName = r.readLine();
        r.close();
        BufferedReader br = new BufferedReader(new FileReader(filName));
        String words  = "";
        while (br.ready()){
            words += br.readLine();
        }
        br.close();
        String[] str = words.split(" ");
        StringBuilder result = getLine(str);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if(words.length > 0) {
            TreeSet<String> ts = new TreeSet<>();
            for (String s : words) {
                ts.add(s);
            }
            ArrayList<String> list = new ArrayList<>();
            list.addAll(ts);
            sb.append(list.get(0));
            String word = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String lastLetter = String.valueOf(word.charAt(word.length() - 1));
                for (int j = 1; j < list.size(); j++) {
                    String firstLetter = String.valueOf(list.get(j).charAt(0));
                    if (lastLetter.equalsIgnoreCase(firstLetter)) {
                        word = list.get(j);
                        sb.append(" " + word);
                    }
                }
            }
            String[] strr = sb.toString().split(" ");
            if(list.size() != strr.length){
                for (int i = 0; i < list.size() ; i++) {
                    if(!sb.toString().contains(list.get(i))){
                        sb.append(" " + list.get(i));
                    }
                }

            }

            return sb;
        } else
            return sb;
    }
}
