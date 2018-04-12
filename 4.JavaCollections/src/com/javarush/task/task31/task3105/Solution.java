package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String zipFilePath = args[1];

        //String filePath = "src/main/resources/level31/lesson06/home01/test.txt";
        //String zipFilePath = "src/main/resources/level31/lesson06/home01/1.zip";
        //createTestZipFile(zipFilePath);

        // get simple file name (without path)
        String fileName = new File(filePath).getName();

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath));
        Map<ZipEntry, byte[]> entryMap = new HashMap<>();
        ZipEntry entry;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int count;
            while ((count = zipInputStream.read(buf)) != -1) {
                byteArrayOutStream.write(buf, 0, count);
            }
            entryMap.put(entry, byteArrayOutStream.toByteArray());
        }
        zipInputStream.close();


        // copy entries to the same zipFile
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFilePath));
        for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()) {
            // skip file with the same name as 'fileName'
            if (fileName.equals(zipEntry.getKey().getName())) {
                continue;
            }
            zipOut.putNextEntry(zipEntry.getKey());
            zipOut.write(zipEntry.getValue());
            zipOut.closeEntry();
        }

        FileInputStream fis = new FileInputStream(filePath);
        byte[] fileBytes = new byte[fis.available()];
        fis.read(fileBytes);
        fis.close();

        // add our file at the end
        ZipEntry zipEntry = new ZipEntry("new/" + fileName);
        zipOut.putNextEntry(zipEntry);
        zipOut.write(fileBytes);
        zipOut.closeEntry();
        zipOut.close();
    }

    // create test .zip file
    private static void createTestZipFile(String zipFilePath) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFilePath));

        zipOut.putNextEntry(new ZipEntry("a.txt"));
        zipOut.write("aaa".getBytes());
        zipOut.closeEntry();

        zipOut.putNextEntry(new ZipEntry("b.txt"));
        zipOut.write("bbb".getBytes());
        zipOut.closeEntry();

        zipOut.putNextEntry(new ZipEntry("test.txt"));
        zipOut.write("afa".getBytes());
        zipOut.closeEntry();

        zipOut.close();
    }
}

