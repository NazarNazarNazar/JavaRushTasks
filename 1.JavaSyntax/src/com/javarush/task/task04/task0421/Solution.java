package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String name2 = reader.readLine();

//        int length = name.length();
//        int length2 = name2.length();

        if (name.equals (name2)){
            System.out.println("Имена идентичны");}
            else if (name.length() == name2.length()){
            System.out.println("Длины имен равны");}
        }
    }
