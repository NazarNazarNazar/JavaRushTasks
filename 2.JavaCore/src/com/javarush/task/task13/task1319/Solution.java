package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new FileWriter(reader.readLine()));

            String str;
            while(true){
                str = reader.readLine();
                writer.write(str);
                writer.newLine();
                if(str.equals("exit"))
                    break;
            }
        } catch (IOException e) {
        }
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
        }
    }
}
