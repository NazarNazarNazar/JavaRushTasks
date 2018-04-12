package com.javarush.task.task14.task1408;
//Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны переопределять метод getDescription родительского класса,
// таким образом, чтобы возвращаемая ими строка имела вид:
// + < Моя страна - Sssss. Я несу N яиц в месяц.> где Sssss - название страны, а N - количество яиц в месяц.
public class RussianHen extends Hen {
    String Sssss = "Russia";
    int N = 10;
    @Override
    int getCountOfEggsPerMonth() {
        return N;
    }

    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Sssss+"."+" Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
