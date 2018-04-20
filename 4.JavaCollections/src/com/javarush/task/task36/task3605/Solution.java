package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<>();
        String file1 = args[0];
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            while (br.ready()) {
                String s = br.readLine().replaceAll("\\W", "");
                for (int i = 0; i < s.length(); i++) {
                    set.add(s.charAt(i));
                }
            }
        }
        Iterator<Character> iterator = set.iterator();
        int n = set.size() < 5 ? set.size() : 5;

        for (int i = 0; i < n; i++) {
            System.out.print((iterator.next()));
        }
    }
}
