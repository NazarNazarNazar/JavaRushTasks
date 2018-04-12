package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).
*/

import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        try (FileInputStream fis = new FileInputStream(args[0])) {
            while (fis.available() > 0){
                int count = fis.read();
                if(map.containsKey(count))
                    map.put(count, map.get(count)+1);
                else map.put((count), 1);
            }
            for(Map.Entry<Integer, Integer> pair : map.entrySet()){
                char ch = (char) Integer.parseInt(pair.getKey().toString());
                System.out.println(ch+" "+pair.getValue());
            }
        }catch (Exception e){

        }
    }
}
