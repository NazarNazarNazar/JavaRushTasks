package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
           fis =new FileInputStream(args[0]);
            int check = 0;
            while (fis.available() > 0){
                int i = fis.read();
                if ((i >= 97 && i <= 122)||(i >= 65 && i <= 90)){
                    check++;
                }
            }
            System.out.println(check);
           fis.close();
        } catch (IOException e){
        }




    }
}
