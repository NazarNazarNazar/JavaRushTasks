package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        ArrayList<Byte> list = new ArrayList<>();
        while (fis.available() > 0) {
            list.add((byte)fis.read());
        }
        reader.close();
        fis.close();
        SortedSet<Byte> treeSet = new TreeSet<>(list);
        for (Byte set : treeSet) {
            System.out.print(set+" ");
        }
    }
}
