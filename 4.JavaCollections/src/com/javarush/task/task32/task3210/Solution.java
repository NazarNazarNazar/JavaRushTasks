package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
//        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            raf.seek(number);
            byte[] buffer = new byte[text.length()];
            raf.read(buffer, 0, text.length());

            String readed = new String(buffer);
            if (readed.equals(text)) {
                raf.seek(raf.length());
                raf.write("true".getBytes("UTF8"));
            } else {
                raf.seek(raf.length());
                raf.write("false".getBytes("UTF8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
