package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();           //наша строчка

        char[] words = s.toCharArray();
        words[0] = Character.toUpperCase(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (Character.isWhitespace(words[i - 1]))
                words[i] = Character.toUpperCase(words[i]);
        }
        s = String.copyValueOf(words);
        System.out.println(s);
        /* запасной вариант который не прошёл из за проблемы с множеством пробелов
        String output = "";                    //все слова с заглавной буквы
        String[] words = s.split("");      //разбиваем строку на массив методом split
        for(String word : words)                //проходим по нему forech
        {
            String first = word.substring(0,1).toUpperCase();
            String all = word.substring(1);
            output += first.concat(all)+" ";
        }
        System.out.println(output);
        */

        //напишите тут ваш код
    }
}
