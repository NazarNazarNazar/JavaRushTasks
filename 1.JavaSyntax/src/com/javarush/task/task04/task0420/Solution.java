package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if(a>=b && a>=c && b>=c){
            System.out.println(a+" "+b+" "+c);}
            else if (b>=a && b>=c && a>=c){
            System.out.println(b+" "+a+" "+c);}
            else if (c>=a && c>=b && a>=b){
            System.out.println(c+" "+a+" "+b);}
            else if (a>=b && a>=c && c>=b){
            System.out.println(a+" "+c+" "+b);}
            else if (b>=a && b>=c && c>=a){
            System.out.println(b+" "+c+" "+a);}
            else if (c>=a && c>=b && b>=a){
            System.out.println(c+" "+b+" "+a);}

        }
    }
