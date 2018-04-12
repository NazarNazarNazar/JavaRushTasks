package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

Возвращает
{"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] buffer = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            buffer[i] = token;
            i++;
        }
        return buffer;
    }
}
