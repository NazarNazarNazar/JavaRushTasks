package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
 Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
Пример для списка 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
                        3
Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x;
        int check = 1;
        int maxCount = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            x = Integer.parseInt(reader.readLine());
            list.add(x);
        }

        for (int i = 1; i < 10 ; i++) {
            if (list.get(i) == list.get(i-1)) check++;
                else check = 1;
                if (maxCount<check)
                    maxCount = check;
        }

        System.out.println(maxCount);


    }
}