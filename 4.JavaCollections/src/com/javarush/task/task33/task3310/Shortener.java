package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    //поле отвечает за последнее значение идентификатора, которое было использовано при добавлении новой строки в хранилище
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    // возвращает идентификатор id для заданно строки
    public synchronized Long getId(String string) {
        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        } else {
            storageStrategy.put(++lastId, string);
            return lastId;
        }
    }

    // возвращает строку для заданного идентификатора или null, если передан неверный идентификатор
    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
