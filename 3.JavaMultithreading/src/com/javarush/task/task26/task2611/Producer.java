package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread t = Thread.currentThread();
            while (!t.isInterrupted()) {
                    Thread.sleep(500);
                    for (int i = 1; i <= 5; i++) {
                        map.put(String.valueOf(i), "Some text for " + i);
                }
            }
        }catch (Exception e) {
            //"[TREAD_NAME] thread was terminated", пример "[thread-1] thread was terminated".
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
