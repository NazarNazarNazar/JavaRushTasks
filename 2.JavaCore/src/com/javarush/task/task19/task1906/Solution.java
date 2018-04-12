package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        String str1 = reader.readLine();
        String str2 = reader.readLine();
            FileReader fr = new FileReader(str1);
            FileWriter fw = new FileWriter(str2);

            int d;
            for (int i = 1; fr.ready() ; i++) {
                d=fr.read();
                if(i%2==0){
                    fw.write(d);
                }
            }
            fr.close();
            fw.close();
        }catch (Exception e) {

        }
    }
}
