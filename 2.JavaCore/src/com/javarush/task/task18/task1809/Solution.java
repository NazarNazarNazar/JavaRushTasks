package com.javarush.task.task18.task1809;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(reader.readLine());
        FileOutputStream fos = new FileOutputStream(reader.readLine());

        while (fis.available() > 0) {
            byte[] bytes = new byte[fis.available()];
            int count = fis.read(bytes);
            for (int i = bytes.length - 1; i >= 0; i--) {
                fos.write(bytes[i]);
            }
        }
        reader.close();
        fis.close();
        fos.close();
    }
}
