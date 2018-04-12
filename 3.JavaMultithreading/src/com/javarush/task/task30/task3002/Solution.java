package com.javarush.task.task30.task3002;

import java.math.BigInteger;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        String result;
        if(s.startsWith("0x")) {
            Integer i = Integer.parseInt(s.substring(2), 16);
            String b = i.toString();
            BigInteger res = new BigInteger(b, 10);
            result = res.toString(10);
            return result;
        } else if(s.startsWith("0b")) {
            Integer i = Integer.parseInt(s.substring(2), 2);
            String b = i.toString();
            BigInteger res = new BigInteger(b, 10);
            result = res.toString(10);
            return result;
        } else if(s.startsWith("0")) {
            Integer i = Integer.parseInt(s.substring(1), 8);
            String b = i.toString();
            BigInteger res = new BigInteger(b, 10);
            result = res.toString(10);
            return result;
        } else {
            BigInteger res = new BigInteger(s, 10);
            result = res.toString(10);
            return result;
        }
    }
}
