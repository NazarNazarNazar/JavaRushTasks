package com.javarush.task.task39.task3904;

import java.util.HashMap;

/*
Лестница
*/
public class Solution {
    private static int n = 70;
//    static HashMap<Integer, Long> map = new HashMap<>();
//
//    static {
//        map.put(0, 1L);
//        map.put(1, 1L);
//        map.put(2, 2L);
//        map.put(3, 4L);
//    }

    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n)); // 2073693258389777176
    }

    public static long countPossibleRunups(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        long[] arr = new long[n + 1];

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
//        if (n < 0)
//            return 0;
//
//        if (map.containsKey(n)) {
//            return map.get(n);
//        } else {
//            long fibonacciValue = ((countPossibleRunups(n - 3) + countPossibleRunups(n - 2)) + countPossibleRunups(n - 1));
//            map.put(n, fibonacciValue);
//            return fibonacciValue;
//        }
    }
}

