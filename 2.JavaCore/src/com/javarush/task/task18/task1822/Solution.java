package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (BufferedReader readerFile = new BufferedReader(new FileReader(new File(reader.readLine())))) {
            String line;
            int id = Integer.parseInt(args[0]);
            while ((line = readerFile.readLine()) != null) {
                if(line.startsWith(id + " "))
                    System.out.println(line+" ");
            }

        } catch (IOException e) {
        }
    }
}
