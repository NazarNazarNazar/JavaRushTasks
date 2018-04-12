package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.UUID;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7smNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        SecureRandom rnd = new SecureRandom();
//
//        for (int i = 0; i < 8 ; i++) {
//            baos.write(AB.charAt(rnd.nextInt(AB.length())));
//        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 3; i++) {
            byteArrayOutputStream.write((byte) (97 + Math.random() * 26));
        }
        for (int i = 3; i < 5; i++) {
            byteArrayOutputStream.write((byte) (65 + Math.random() * 26));
        }
        for (int i = 5; i < 8; i++) {
            byteArrayOutputStream.write(48 + (byte) (Math.random() * 9));
        }
        return byteArrayOutputStream;
    }
}