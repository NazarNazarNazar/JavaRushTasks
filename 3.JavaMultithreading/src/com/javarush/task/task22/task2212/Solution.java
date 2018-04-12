package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) {
            return false;
        }
        int numbers = (telNumber.charAt(0) == '+' ? 12 : 10);
        if (telNumber.replaceAll("\\D", "").length() != numbers)
            return false;
        if (telNumber.matches("--"))
            return false;
        return telNumber.matches("(\\+\\d{2}\\(?\\d{3}\\)?\\d{3}-?\\d{2}-?\\d{2})||\\d{6}-?\\d{2}-?\\d{2}");
    }

    public static void main(String[] args) {
        String telNumber = "+987665544456";
        System.out.println(checkTelNumber(telNumber));

    }
}
