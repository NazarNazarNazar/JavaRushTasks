package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static{
        labels.put(12.3, "dfasfa");
        labels.put(123.3, "dfasfalll");
        labels.put(1233.3, "dfalsfa");
        labels.put(12333.3, "dgfasfa");
        labels.put(123333.3, "dfajsfa");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
