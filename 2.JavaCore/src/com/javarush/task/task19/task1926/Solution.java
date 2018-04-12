package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ourFile = reader.readLine();
        FileReader fr = new FileReader(ourFile);
        BufferedReader bf = new BufferedReader(fr);
        reader.close();
        while (bf.ready()) {
            System.out.println(new StringBuilder(bf.readLine()).reverse().toString());
        }
        fr.close();
        bf.close();
    }
}
