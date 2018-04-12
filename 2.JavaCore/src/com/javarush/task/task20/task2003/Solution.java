package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream fis = new FileInputStream(name);
        Properties prop = new Properties();
        load(fis);
        prop.putAll(properties);
        reader.close();
        fis.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties1 = new Properties();
        properties1.putAll(properties);
        properties1.store(outputStream, " ");

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties2 = new Properties();
        properties2.load(inputStream);
        properties2.forEach((x, y) -> {
            properties.put((String) x, (String) y);
        });
    }

    public static void main(String[] args) {

    }
}
