package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        String newS = s;

        for (int i = 0; i < 40 ; i++) {
            int deletePosition = i;
            newS = s.substring(deletePosition);
            System.out.println(newS);
        }

//        char[] newS = s.toCharArray();
//        ArrayList<Character> list = new ArrayList<>();
//        for (int i = 0; i <  list.size(); i++) {
//            list.add(newS[i]);
//        }
//        //напишите тут ваш код
//        for (int i = 0; i < list.size() ; i++) {
//            System.out.println(list);
//            list.remove(0);
//        }
    }

}

