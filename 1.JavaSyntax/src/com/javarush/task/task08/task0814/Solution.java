package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* 
Больше 10? Вы нам не подходите
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> setAdd = new HashSet<>();
        setAdd.add(2);
        setAdd.add(22);
        setAdd.add(12);
        setAdd.add(23);
        setAdd.add(3);
        setAdd.add(266);
        setAdd.add(6);
        setAdd.add(7);
        setAdd.add(77);
        setAdd.add(31);
        setAdd.add(4);
        setAdd.add(45);
        setAdd.add(55);
        setAdd.add(5);
        setAdd.add(777);
        setAdd.add(9);
        setAdd.add(8);
        setAdd.add(1);
        setAdd.add(44);
        setAdd.add(234);

        return setAdd;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
            if (iterator.next() > 10)
                iterator.remove();

        return set;
    }

    public static void main(String[] args) {
    }
}
