package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
 Имя
- Имя, рост
- Имя, рост, цвет
*/


public class Dog {
    //напишите тут ваш код
    private String name;
    private int height;
    private String color;

    public Dog (String surname)
    {
        this.name = surname;
        this.height = 193;
        this.color = "Auburn";
    }

    public Dog (String firstname, int height)
    {
        this.name = firstname;
        this.height = height;
        this.color = "Auburn1";
    }

    public Dog (String nnname, int wheight, String tricolor)
    {
        this.name = nnname;
        this.height = wheight;
        this.color = tricolor;
    }

    public static void main(String[] args) {

    }
}
