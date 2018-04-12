package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        reader.close();

        BufferedReader rd = new BufferedReader(new FileReader(str1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(str2));

        while (rd.ready()) {
            String s = rd.readLine().replace(".", "!");
            bw.write(s+" ");
        }
        rd.close();
        bw.close();

    }
}
