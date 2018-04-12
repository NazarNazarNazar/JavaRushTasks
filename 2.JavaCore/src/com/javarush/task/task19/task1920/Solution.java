package com.javarush.task.task19.task1920;

/* 
Самый богатый
while (br.ready()) {
            String fullString = br.readLine();
            String name = fullString.replaceAll("\\d", "").trim();
            String doub = fullString.substring(name.length()+1);
            Double d = Double.parseDouble(doub);
            map.put(name, d);
        }

        double maxValue = 0;
        for (Map.Entry<String, Double> pair : map.entrySet()){
            if (maxValue < pair.getValue()){
                maxValue = pair.getValue();
            }
        }
        for (Map.Entry<String, Double> pair : map.entrySet()){
            if (pair.getValue().equals(maxValue)){
                System.out.print(pair.getKey()+" ");
            }
        }
*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
//        while (br.ready()) {
//            String[] buffer = br.readLine().split(" ");
//            String name = buffer[0];
//            Double db = Double.parseDouble(buffer[1]);
//            map.put(name, db);
//        }
        String line;
        while (br.ready()) {
            line = br.readLine();
            String[] s = line.split(" ", 2);
            Double d = Double.parseDouble(s[1]);
            map.merge(s[0], d, (aDouble, aDouble2) -> aDouble + aDouble2);
        }
            Double maxValue = Collections.max(map.values());
            for (Map.Entry<String, Double> pair : map.entrySet()) {
                if (pair.getValue().equals(maxValue))
                    System.out.println(pair.getKey());
            }
        br.close();
    }
}
