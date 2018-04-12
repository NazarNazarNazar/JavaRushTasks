package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> str = new ArrayList<>();
        int max = 0;
        int min = 0;
        for (int i = 0; i < 10; i++) {
            str.add(reader.readLine());
            if (str.get(i).length() < str.get(min).length()) {
                min = i;//напишите тут ваш код
            }
            if (str.get(i).length() > str.get(max).length()) {
                max = i;//напишите тут ваш код
            }
        }
        if (max < min) {
            System.out.println(str.get(max));
        } else {
            System.out.println(str.get(min));
        }
        ;
    }
}
