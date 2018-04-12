package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if(b <= a && b <= c && a >= c)
            System.out.println(c);
        else if(a <= b && a <= c && b >= c)
            System.out.println(c);
        else if(c <= b && c <= a && b >= a)
            System.out.println(a);
        else if(c <= b && c <= a && a >= b)
            System.out.println(b);
        else if(b <=c && b <= a && c >= a)
            System.out.println(a);
        else if(a <= c && a <= b && c >= b)
            System.out.println(b);
    }
}
