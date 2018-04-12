package com.javarush.task.task08.task0811;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Квартет «Методы»
Реализовать 4 метода.
Каждый из них должен возвращать список, который лучше всего подходит для выполнения данных операций
(быстрее всего справится с большим количеством операций).
Ничего измерять не нужно.
*/

public class Solution {
    public static List getListForGet() {
        //напишите тут ваш код
        ArrayList<Object> list = new ArrayList();
        for (int i = 0; i < list.size() ; i++) {
            list.add(i);
        }
        return list;
    }

    public static List getListForSet() {
        //напишите тут ваш код
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            list.add(i);
        }
        return list;
    }

    public static List getListForAddOrInsert() {
        //напишите тут ваш код
        LinkedList<Object> linkedList = new LinkedList<>();
        for (int i = 0; i < linkedList.size() ; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }

    public static List getListForRemove() {
        //напишите тут ваш код
        LinkedList<Object> linkedList = new LinkedList<>();
        for (int i = 0; i < linkedList.size() ; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }

    public static void main(String[] args) {

    }
}
