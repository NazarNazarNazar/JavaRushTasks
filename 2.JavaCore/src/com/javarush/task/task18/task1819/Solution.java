package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fis1 = new FileInputStream(fileName1);
        FileOutputStream fos1 = new FileOutputStream(fileName1, true);

        FileInputStream fis2 = new FileInputStream(fileName2);

        byte[] buffer = new byte[fis1.available()];
        fis1.read(buffer);

        byte[] buffer2 = new byte[fis2.available()];
        fis2.read(buffer2);

        fos1.write(buffer2);
        fos1.write(buffer);

        reader.close();
        fos1.close();
        fis1.close();
        fis2.close();
    }
}
