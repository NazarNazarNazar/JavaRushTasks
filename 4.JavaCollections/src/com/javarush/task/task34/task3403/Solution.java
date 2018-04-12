package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        if(n <= 1) return;

        int k = 2;

        while (true){
            if (n%k == 0) {
                int nextInt = n/k;
                if(nextInt > 1) {
                    System.out.println(k+" ");
                    recursion(nextInt);
                    return;
                }
                else if (nextInt == 1) {
                    System.out.println(k);
                    return;
                }
            }
            k++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
