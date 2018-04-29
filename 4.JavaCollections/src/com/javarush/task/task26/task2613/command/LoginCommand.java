package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".login");
    private ResourceBundle validCreditCards =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");
//    private String CARD_NUMBER = "123456789012";
//    private String CARD_PIN = "1234";

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNum = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();

            if (!cardNum.matches("^\\d{12}$") && !pin.matches("^\\d{4}$")) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            if (validCreditCards.containsKey(cardNum)) {
                if (!validCreditCards.getString(cardNum).equals(pin)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNum));
                    ConsoleHelper.writeMessage(String.format(res.getString("try.again.or.exit")));
                } else {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNum));
                    break;
                }
            }

//            if(!cardNum.equals(CARD_NUMBER) && pin.equals(CARD_PIN)) {
//                ConsoleHelper.writeMessage("Not match");
//                continue;
//            } else {
//                ConsoleHelper.writeMessage("Verification is successful");
//                break;
//            }
        }
    }
}
