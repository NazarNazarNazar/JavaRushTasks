package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        FileInputStream fis = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fis = new FileInputStream(reader.readLine());
            int min = Integer.MAX_VALUE;
            while (fis.available() > 0){
                int b =fis.read();
                if(min > b)
                    min = b;
            }
            System.out.println(min);
            reader.close();
            fis.close();
        }catch (IOException e){
        }
    }
}
