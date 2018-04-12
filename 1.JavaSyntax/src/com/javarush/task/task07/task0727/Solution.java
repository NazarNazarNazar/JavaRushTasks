package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
Программа вводит строки, пока пользователь
не введёт пустую строку (нажав enter).
Потом программа строит новый список.
Если в строке чётное число букв, строка удваивается,
если нечётное - утраивается.
Программа выводит содержимое нового списка на экран.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        for (int i = 0; i < list.size() ; i++) {
            String s = list.get(i);
            if(s.length()%2==0)
                System.out.println(s+" "+s);
            else if(s.length()%2 != 0)
                System.out.println(s+" "+s+" "+s);
        }

        // ArrayList<String> listNew = new ArrayList<>();

        /*ArrayList<String> listUpperCase = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            listUpperCase.add(s.toUpperCase());
        }

        for (int i = 0; i < listUpperCase.size(); i++) {
            System.out.println(listUpperCase.get(i));
        }*/
    }
}
