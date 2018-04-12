package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int limit = 3;
        int i = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int positiveCount = 0;
        int negativeCount = 0;
        while (i < limit){
            int tmp = Integer.parseInt(reader.readLine());
            if(tmp > 0) positiveCount++;
            if(tmp < 0) negativeCount++; i++; }
            System.out.println("количество отрицательных чисел: "+negativeCount);
            System.out.println("количество положительных чисел: "+positiveCount);

    }
}
