package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);
        int checkSpace = 0;
        int checkLetters = 0;
        int count = -1;
        while ((count = fis.read()) != -1) {
            checkLetters++;
            if(count == (int) ' ')
                checkSpace++;
        }
        System.out.println(String.format("%.2f",((double) checkSpace/checkLetters*100)));
        fis.close();
    }
}
