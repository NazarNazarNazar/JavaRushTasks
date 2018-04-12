package com.javarush.task.task32.task3209;

import java.io.File;

public class HTMLFileFilter extends javax.swing.filechooser.FileFilter {


    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        if (!f.isDirectory()) {
            String fileName = f.getName().toLowerCase();
            return fileName.endsWith(".html") || fileName.endsWith(".htm");
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
