package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int minimum = min(a, b, c, d, e);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int e)
    {
        int minimum = 0;
        if (a<=b && a<=c && a<=d && a<=e) { minimum = a; }
        else if (b<=a && b<=c && b<=d && b<=e) { minimum = b; }
        else if (c<=a && c<=b && c<=d && c<=e) { minimum = c; }
        else if (d<=a && d<=c && d<=b && d<=e) { minimum = d; }
        else if (e<=a && e<=c && e<=b && e<=d) { minimum = e; }
        return minimum;
    }
}
