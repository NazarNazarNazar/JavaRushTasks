package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        Charset Windows_1251 = Charset.forName("Windows-1251");
        Charset UTF_8 = Charset.forName("UTF-8");
        while (fis.available() > 0) {
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            String s = new String(buf, Windows_1251);
            buf = s.getBytes(UTF_8);
            fos.write(buf);
        }
    }
}
