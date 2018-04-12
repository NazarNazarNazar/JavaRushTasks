package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str1 = reader.readLine();
            String str2 = reader.readLine();
            BufferedReader reader1 = new BufferedReader(new FileReader(str1));
            BufferedReader reader2 = new BufferedReader(new FileReader(str2));
            String line;
            while ((line = reader1.readLine()) != null){
                allLines.add(line);
            }

            String line2;
            while ((line2 = reader2.readLine()) != null){
                forRemoveLines.add(String.valueOf(line2));
            }
            reader.close();
            reader1.close();
            reader2.close();
            }catch (IOException e) {
        }
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
        }


    }

    public void joinData () throws CorruptedDataException {
            if(allLines.containsAll(forRemoveLines)) {
                allLines.removeAll(forRemoveLines);
            }
            else {
                allLines.clear();
                throw new CorruptedDataException();
            }
    }
}
