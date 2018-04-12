package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fr1 = new FileReader(file1);
        FileReader fr2 = new FileReader(file2);
        String str1 = "";
        String str2 = "";
        while (fr1.ready() && fr2.ready()) {
            str1 += Character.toString((char)fr1.read());
            str2 += Character.toString((char)fr2.read());
            String[] text1 = str1.split(" ");
            String[] text2 = str2.split(" ");
            for (int i = 0; i < text1.length ; i++) {
                for (int j = 0; j < text2.length ; j++) {
                    if(text1[i].equals(text2[j]))
                        lines.add(new LineItem(Type.SAME, text2[j]));
                    if(!text1[i].equals(text2[j]))
                        lines.add(new LineItem(Type.REMOVED, text1[i]));
                    if(!text2[j].equals(text1[i]))
                        lines.add(new LineItem(Type.ADDED, text2[j]));
                }
            }
        }
        fr1.close();
        fr2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
