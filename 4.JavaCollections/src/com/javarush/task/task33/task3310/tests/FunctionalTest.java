package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        // текст 1 и 3 строк должен быть одинаковым
        String string1 = Helper.generateRandomString();
        String string2 = Helper.generateRandomString();
        String string3 = string1;

        // получать и сохранять идентификаторы
        Long identificator1 = shortener.getId(string1);
        Long identificator2 = shortener.getId(string2);
        Long identificator3 = shortener.getId(string3);

        // проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк
        Assert.assertNotEquals(identificator2, identificator1);
        Assert.assertNotEquals(identificator2, identificator3);

        // проверять, что идентификаторы для 1 и 3 строк равны
        Assert.assertEquals(identificator1, identificator3);

        // получать три строки по трем идентификаторам и эквивалентны оригинальным
        Assert.assertEquals(string1, shortener.getString(identificator1));
        Assert.assertEquals(string2, shortener.getString(identificator2));
        Assert.assertEquals(string3, shortener.getString(identificator3));
    }

    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy hmss = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hmss);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy ohmss = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ohmss);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        FileStorageStrategy fss = new FileStorageStrategy();
        Shortener shortener = new Shortener(fss);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy hbmss = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hbmss);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy dhbmss = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dhbmss);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy ohbmss = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ohbmss);
        testStorage(shortener);
    }
}
