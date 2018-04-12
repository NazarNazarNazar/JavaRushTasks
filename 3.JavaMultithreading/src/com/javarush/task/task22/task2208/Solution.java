package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if(params != null){
            for(Map.Entry<String, String> pair : params.entrySet()) {
                if(pair.getValue() != null) {
                    sb.append(String.format("%s = '%s' and ", pair.getKey(), pair.getValue()));
                }
            }
        }
        if (sb.length() != 0)
            sb.delete(sb.length()-5, sb.length());
        return sb.toString();
    }
}
