package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> mainList = new ArrayList<>();
        ArrayList<Integer> devision3 = new ArrayList<>();
        ArrayList<Integer> devision2 = new ArrayList<>();
        ArrayList<Integer> restDevision = new ArrayList<>();

        int in;
        for (int i = 0; i < 20 ; i++) {
            in = Integer.parseInt(reader.readLine());
            mainList.add(in);
            if(in%3==0 || in%3==0 && in%2==0) devision3.add(in);
            if(in%2==0) devision2.add(in);
            if(in%3 != 0 && in%2 != 0)
                restDevision.add(in);
        }

        printList(devision2);
        printList(devision3);
        printList(restDevision);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for(Integer x: list){
            System.out.println(x);
        }
    }
}
