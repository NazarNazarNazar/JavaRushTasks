package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> lizt = new ArrayList<>();
        lizt.add("Hasta");
        lizt.add("La");
        lizt.add("Victoria");
        lizt.add("siempre");
        lizt.add("!!!");

        System.out.println(lizt.size());

        for(Object i: lizt){
            System.out.println(i);
        }


    }
}
