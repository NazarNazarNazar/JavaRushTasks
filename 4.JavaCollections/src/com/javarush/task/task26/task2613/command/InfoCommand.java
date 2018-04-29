package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".info");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));

        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty()) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }

        for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (cur.hasMoney() && cur.getTotalAmount() > 0) {
                ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + cur.getTotalAmount());
            } else {
                ConsoleHelper.writeMessage(res.getString("no.money"));
            }
        }
    }
}
//        boolean hasMoney = false;
//        Iterator<CurrencyManipulator> iterator =
//                CurrencyManipulatorFactory.getAllCurrencyManipulators().iterator();
//        while (iterator.hasNext()) {
//            CurrencyManipulator manipulator = iterator.next();
//            if (manipulator.hasMoney()) {
//                hasMoney = true;
//                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
//            }
//        }
//        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty() || !hasMoney) {
//            ConsoleHelper.writeMessage("No money available.");
//        }

//        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
//            if (manipulator.hasMoney())
//                ConsoleHelper.writeMessage(String.format("%s - %s", manipulator.getCurrencyCode(), manipulator.getTotalAmount()));
//            else ConsoleHelper.writeMessage("No money available.");
//        }
//        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty())
//            ConsoleHelper.writeMessage("No money available.");
//    }

//        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().size() == 0) {
//            ConsoleHelper.writeMessage("No money available.");
//        } else {
//            int counter = 0;
//            for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
//
//                ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + cur.getTotalAmount());
//                counter++;
//            }
//            if (counter == 0)
//                ConsoleHelper.writeMessage("No money available.");
//        }
//    }
