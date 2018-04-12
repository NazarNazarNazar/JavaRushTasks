package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        int a = 0;
        int b = 0;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (a <= 0 || b <= 0) {
            throw new Exception();
        }
            while (b != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
        System.out.println(a);

    }

}
