package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
Вычисление расстояния между взятыми на плоскости двумя точками А(хА; уА) и В(хВ; уВ),
выполняется по формуле d = √((хА – хВ)2 + (уА – уВ)2),
где d – длина отрезка, который соединяет эти точки на плоскости
*/

import static java.lang.Math.sqrt;

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        double a = ((x1 - x2)*(x1 - x2)+(y1 - y2)*(y1 - y2));
        return Math.sqrt(a);



    }

    public static void main(String[] args) {

    }
}
