package com.javarush.task.task33.task3310.strategy;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);
            Files.createFile(path);
            Files.deleteIfExists(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // возвращает размер файла на который указывает path
    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    // сериализовывает переданный entry в файл
    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            for (Entry e = entry; e != null; e = e.next) {
                oos.writeObject(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // забирает entry из файла, если файл имеет нулевой размер вернуть null
    public Entry getEntry() {
        Entry entry = null;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            if (this.getFileSize() == 0) {
                return null;
            } else {
                entry = (Entry) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return entry;
    }

    // удаляет файл на который указывает path
    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
