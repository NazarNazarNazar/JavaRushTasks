package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws ParseException {
            String stringFromScanner = fileScanner.nextLine();
            String[] buffer = stringFromScanner.split(" ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            Date date = sdf.parse(String.format( "%s %s %s",buffer[3] ,buffer[4] ,buffer[5]));
            Person person = new Person(buffer[1], buffer[2], buffer[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
