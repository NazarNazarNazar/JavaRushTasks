package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.Date;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = new Date();
        Integer integer = (Integer) object;
    }

    public void methodThrowsNullPointerException() {
        String num = null;
        num.trim();
    }

    public static void main(String[] args) {

    }
}
