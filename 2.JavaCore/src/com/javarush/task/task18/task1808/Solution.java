package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis1 = new FileInputStream(reader.readLine());
        FileOutputStream fis2 = new FileOutputStream(reader.readLine());
        FileOutputStream fis3 = new FileOutputStream(reader.readLine());

        if (fis1.available() > 0) {
            byte[] bytes = new byte[fis1.available()];
            int count = fis1.read(bytes);
            fis2.write(bytes, 0, count - count/2);
            fis3.write(bytes, count - count/2, count- (count- count/2));
        }
        reader.close();
        fis1.close();
        fis2.close();
        fis3.close();
    }
}
