package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Integer m, Integer n, Double value) {

    }

    public static void printMatrix(int m, int n) {

    }
    public static void printMatrix(Object m, Object n, String str) {

    }
    public static void printMatrix(String b, String c, String str) {

    }
    public static void printMatrix(Double b, Double c, Double m) {

    }
    public static void printMatrix(Integer a, Integer b, Integer c) {

    }
    public static void printMatrix(Float a, Float b, Float c) {

    }
    public static void printMatrix(int a, int b, int c) {

    }
}
