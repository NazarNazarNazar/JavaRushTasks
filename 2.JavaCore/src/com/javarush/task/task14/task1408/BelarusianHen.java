package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    String Sssss = "Belarus";
    int N = 13;
    @Override
    int getCountOfEggsPerMonth() {
        return N;
    }

    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Sssss+"."+" Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
