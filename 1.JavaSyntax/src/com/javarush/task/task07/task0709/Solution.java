package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            strings.add(s);
            a = (strings.get(i).length() <= a) ? strings.get(i).length() : a;
        }

        for(String s: strings){
            if(s.length() == a) System.out.println(s);
        }



    }
}
