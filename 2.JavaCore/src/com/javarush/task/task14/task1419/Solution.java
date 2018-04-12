package com.javarush.task.task14.task1419;

import javax.management.remote.JMXServerErrorException;
import javax.xml.crypto.KeySelectorException;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystemLoopException;
import java.security.KeyException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
            try {
                float i = 1 / 0;

            } catch (Exception e1) {
                exceptions.add(e1);
                try {
                    float i = 1 / 0;

                } catch (Exception e2) {
                    exceptions.add(e2);
                }
                try {
                    float i = 1 / 0;

                } catch (Exception e3) {
                    exceptions.add(e3);
                }
                try {
                    float i = 1 / 0;

                } catch (Exception e4) {
                    exceptions.add(e4);
                }
                try {
                    float i = 1 / 0;

                } catch (Exception e5) {
                    exceptions.add(e5);
                }
                try {
                    float i = 1 / 0;

                } catch (Exception e6) {
                    exceptions.add(e6);
                }
                try {
                    float i = 1 / 0;

                } catch (Exception e7) {
                    exceptions.add(e7);
                }
                try {
                    float i = 1 / 0;

                } catch (Exception e8) {
                    exceptions.add(e8);
                }
                try {
                    float i = 1 / 0;

                } catch (Exception e9) {
                    exceptions.add(e9);
                }


                //            try {
//                throw new IndexOutOfBoundsException();
//            } catch (IndexOutOfBoundsException e1) {
//                exceptions.add(e1);
//            }
//            try {
//                throw new NullPointerException();
//            } catch (NullPointerException e2) {
//                exceptions.add(e2);
//            }
//            try {
//                throw new ArithmeticException();
//            } catch (ArithmeticException e3) {
//                exceptions.add(e3);
//            }
//            try {
//                throw new FileNotFoundException();
//            } catch (FileNotFoundException e4) {
//                exceptions.add(e4);
//            }
//            try {
//                throw new FileSystemAlreadyExistsException();
//            } catch (FileSystemAlreadyExistsException e5) {
//                exceptions.add(e5);
//            }
//            try {
//                throw new ArrayStoreException();
//            } catch (ArrayStoreException e6) {
//                exceptions.add(e6);
//            }
//            try {
//                throw new JarException();
//            } catch (JarException e7) {
//                exceptions.add(e7);
//            }
//            try {
//                throw new KeyException();
//            } catch (KeyException e8) {
//                exceptions.add(e8);
//            }
//            try {
//                throw new RuntimeException();
//            } catch (RuntimeException e9) {
//                exceptions.add(e9);
//            }

                //напишите тут ваш код
            }
        }
    }
}
