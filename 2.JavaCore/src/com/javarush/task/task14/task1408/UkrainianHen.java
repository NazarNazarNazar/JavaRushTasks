package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    String Sssss = "Ukraine";
    int N = 12;
    @Override
    int getCountOfEggsPerMonth() {
        return N;
    }

    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Sssss+"."+" Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
