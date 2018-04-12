package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        ArrayList<Byte> list = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();

        while (fis.available() > 0) {
            list.add((byte)fis.read());
        }
        reader.close();
        fis.close();

        int count;
        for (int i = 0; i < list.size() ; i++) {
            count = Collections.frequency(list, list.get(i));
            map.put(list.get(i), count);
        }
        int min = Collections.min(map.values());
        for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
            if(pair.getValue() == min)
                System.out.print(pair.getKey()+" ");
        }

    }
}
