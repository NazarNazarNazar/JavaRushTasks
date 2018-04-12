package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            String fileName = reader.readLine();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            int num;
            while (bufferedReader.ready()) {
                num = Integer.parseInt(bufferedReader.readLine());
                if (num % 2 == 0)
                list.add(num);
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        Collections.sort(list);
        for(Integer x : list) {
            System.out.println(x);
        }


    }
}
