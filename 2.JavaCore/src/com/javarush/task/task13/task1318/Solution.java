package com.javarush.task.task13.task1318;

import java.io.*;
/* 
Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 InputStream inputStream = new FileInputStream(reader.readLine());
 while (inputStream.available()>0)
 {
 System.out.print((char) inputStream.read());
 }
  System.out.println();
inputStream.close();
reader.close();
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

//        BufferedReader reader = null;
//        InputStream inputStream = null;
//        InputStreamReader isr = null;
//        int b;
//        try {
//            reader = new BufferedReader(new InputStreamReader(System.in));
//            inputStream = new FileInputStream(reader.readLine());
//            isr = new InputStreamReader(inputStream, "UTF-8");
//            b = isr.read();
//            while(b != -1){
//                System.out.print((char)b);
//            }
//        }catch (IOException e){}

        BufferedReader reader = null;
        InputStream inputStream = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            inputStream = new FileInputStream(reader.readLine());
            while (inputStream.available() > 0){
                System.out.print((char)inputStream.read());
            }
        }catch (IOException e){

        }
        reader.close();
        inputStream.close();
    }
}