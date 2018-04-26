package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable createException(Enum en) {
        if (en == null) {
            return new IllegalArgumentException();
        }

        String message = en.name().charAt(0) + en.name().substring(1).toLowerCase().replaceAll("_", " ");

        if (en instanceof ExceptionApplicationMessage) {
            return new Exception(message);
        }

        if (en instanceof ExceptionDBMessage) {
            return new RuntimeException(message);
        }

        if (en instanceof ExceptionUserMessage) {
            return new Error(message);
        }
        return new IllegalArgumentException();
    }
}
