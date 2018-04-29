package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;

@SuppressWarnings("ALL")
public class CurrencyManipulatorFactory {
    private static CurrencyManipulatorFactory ourInstance = new CurrencyManipulatorFactory();
    private static HashMap<String, CurrencyManipulator> currencyManipulators = new HashMap<>();

    public static CurrencyManipulatorFactory getInstance() {
        return ourInstance;
    }

    private CurrencyManipulatorFactory() {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return currencyManipulators.values();
    }


    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (currencyManipulators.get(currencyCode) != null)
            return currencyManipulators.get(currencyCode);
        else {
            CurrencyManipulator newCurrencyManipulator = new CurrencyManipulator(currencyCode);
            currencyManipulators.put(currencyCode, newCurrencyManipulator);
            return newCurrencyManipulator;
        }
    }
}
