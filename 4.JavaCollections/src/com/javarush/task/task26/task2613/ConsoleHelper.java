package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".common");

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("operation.DEPOSIT"));
        writeMessage(res.getString("operation.WITHDRAW"));
        writeMessage(res.getString("operation.EXIT"));
        writeMessage(res.getString("operation.INFO"));
        do {
            String op = ConsoleHelper.readString();

            if (op.matches("^[1-4]$")) {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(op));
            } else {
                writeMessage(res.getString("invalid.data"));
            }
        } while (true);
//        do {
//            try {
//                int op = Integer.parseInt(ConsoleHelper.readString());
//                return Operation.getAllowableOperationByOrdinal(op);
//            } catch (Exception ex) {
//                writeMessage("Введите операцию повторно: ");
//            }
//        } while (true);
    }


    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String result;
        do {
            result = readString();
            if (result.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            } else break;
        } while (true);
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String.format(res.getString("choose.denomination.and.count.format"), currencyCode);
        String[] result;

        do {
            try {
                result = readString().split(" ");
                if (result.length != 2) {
                    throw new NumberFormatException();
                }
                int nominal = Integer.parseInt(result[0]);
                int amountBills = Integer.parseInt(result[1]);
                if (nominal <= 0 || amountBills <= 0) {
                    writeMessage(res.getString("invalid.data"));
                }
                break;
            } catch (NumberFormatException ex) {
                writeMessage(res.getString("invalid.data"));
            }
        } while (true);

        return result;
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = "";
        try {
            result = bis.readLine();
            if (result.equalsIgnoreCase(res.getString("operation.EXIT"))) throw new InterruptOperationException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
