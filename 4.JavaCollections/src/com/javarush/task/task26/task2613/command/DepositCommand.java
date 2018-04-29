package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res =  ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".deposit");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] digits;
        int denomination = 0;
        int count = 0;
        try {
            digits = ConsoleHelper.getValidTwoDigits(currencyCode);
            denomination = Integer.parseInt(digits[0]);
            count = Integer.parseInt(digits[1]);
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        if (denomination > 0 && count > 0) {
            manipulator.addAmount(denomination, count);
        }
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denomination * count, currencyCode));
    }
//    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.deposit");
//
//    @Override
//    public void execute() throws InterruptOperationException {
//        ConsoleHelper.writeMessage(res.getString("before"));
//
//        String currencyCode = ConsoleHelper.askCurrencyCode().toUpperCase();
//        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//        String[] toDigits = ConsoleHelper.getValidTwoDigits(currencyCode);
//        try {
//            int denomination = Integer.parseInt(toDigits[0]);
//            int denominationCount = Integer.parseInt(toDigits[1]);
//            cm.addAmount(denomination, denominationCount);
//            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denomination * denominationCount, currencyCode));
//        } catch (NullPointerException ex) {
//            ConsoleHelper.writeMessage(res.getString("invalid.data"));
//        }
//    }
}
