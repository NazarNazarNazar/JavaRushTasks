package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> list = new ArrayList<>();
        Throwable th = e;
        while (th != null) {
            list.add(th);
            th = th.getCause();
        }
        Collections.reverse(list);
        for(Throwable x : list) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
    }
}
