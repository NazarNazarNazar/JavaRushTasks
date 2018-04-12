package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fos = new FileOutputStream(reader.readLine(), true);
        FileInputStream fis1 = new FileInputStream(reader.readLine());
        FileInputStream fis2 = new FileInputStream(reader.readLine());

        while (fis1.available() > 0) {
            fos.write(fis1.read());
        }
        fis1.close();
        while (fis2.available() > 0) {
            fos.write(fis2.read());
        }
        reader.close();
        fos.close();
        fis2.close();

    }
}
