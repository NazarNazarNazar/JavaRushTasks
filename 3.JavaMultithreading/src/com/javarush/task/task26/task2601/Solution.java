package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        int mediana;
        Arrays.sort(array);
        if(array.length %2 == 0)
            mediana = (array[array.length/2] + array[array.length/2-1])/2;
        else mediana = array[array.length/2];

        double finalmediana = mediana;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = (int) (Math.abs(o1 - finalmediana) - (Math.abs(o2 - finalmediana)));
                return result == 0 ? o1 - o2 : result;
            }
        };
        Arrays.sort(array, comparator);
        return array;
    }
}
