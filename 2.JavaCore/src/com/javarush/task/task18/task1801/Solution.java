package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        FileInputStream fileInputStream = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileInputStream = new FileInputStream(reader.readLine());
            int max = fileInputStream.read();
            while (fileInputStream.available() > 0) {
                int i = fileInputStream.read();
                if(i > max)
                    max = i;
                }
            System.out.println(max);
            reader.close();
            fileInputStream.close();
        }catch (IOException e){
        }
    }
}
