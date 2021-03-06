package com.javarush.task.task10.task1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Поправочки нужны
Задача: Программа демонстрирует работу HashMap: вводит с клавиатуры набор пар (номер и строку),
помещает их в HashMap и выводит на экран содержимое HashMap.
*/

public class Solution {
    HashMap<Integer, String> map;
    static Integer index;
    static String name;

    public Solution() {
        this.map = new HashMap<>();
//        map.put(index, name); //закоментировать строку?
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            index = Integer.parseInt(reader.readLine());
            name = reader.readLine();
            solution.map.put(index, name);
        }

        for (Map.Entry<Integer, String> pair : solution.map.entrySet()) {
            int index = pair.getKey();
            String name = pair.getValue();
            System.out.println("Id=" + index + " Name=" + name);
        }
    }
}
