package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));


        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        String cc = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(cc);
        int amount;
        Map<Integer, Integer> withdrawMap = null;
        while (true) {
            String amountS = ConsoleHelper.readString();
            try {
                amount = Integer.parseInt(amountS);
            } catch (NumberFormatException nfe) {
                ConsoleHelper.writeMessage("wrong amount");
                continue;
            }
            if (amount <= 0) {
                ConsoleHelper.writeMessage("wrong amount");
                continue;
            }
            if (!cm.isAmountAvailable(amount)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try {
                withdrawMap = cm.withdrawAmount(amount);
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            for (Map.Entry<Integer, Integer> pair : withdrawMap.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, cc));
            break;
        }
    }
}
