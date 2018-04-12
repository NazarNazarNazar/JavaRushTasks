package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if (is != null) {
            byte[] buffer = new byte[1024];
            InputStreamReader isr = new InputStreamReader(is);
            int b;
            while ((b = isr.read()) > 0) {
                sw.write(b);
            }
        }

        return sw;
    }
}