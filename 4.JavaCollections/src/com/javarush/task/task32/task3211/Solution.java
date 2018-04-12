package com.javarush.task.task32.task3211;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
Представь ситуацию, ты выкачал архив с интернета, и в момент скачивания у тебя на несколько секунд пропало соединение.
Нужно убедиться, валидный ли архив ты скачал. Для этого сверим его MD5 хеш.
Прочитать о MD5 на wiki.
Прочитать о MessageDigest.
Реализуй логику метода compareMD5, который должен получать MD5 хеш из переданного ByteArrayOutputStream и сравнивать с эталонным MD5 переданным вторым параметром.
Метод main не участвует в тестировании.
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true
    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest mdBaos = MessageDigest.getInstance("MD5");
        mdBaos.update(byteArrayOutputStream.toByteArray());
        byte[] bufferBaos = mdBaos.digest();

        StringBuilder sbBaos = new StringBuilder();
        for (int i = 0; i < bufferBaos.length ; i++) {
            sbBaos.append(Integer.toString((bufferBaos[i] & 0xff) + 0x100, 16).substring(1));
        }

        return MessageDigest.isEqual(md5.getBytes(), sbBaos.toString().getBytes());
    }
}
