package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        TreeMap <String, Double> map = new TreeMap<>();
        while (br.ready()) {
            String[] buffer = br.readLine().split(" ");
            String name = buffer[0];
            Double doub = Double.parseDouble(buffer[1]);
            map.put(name, map.containsKey(name) ? map.get(name) + doub : doub);
        }
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
        br.close();
    }
}
