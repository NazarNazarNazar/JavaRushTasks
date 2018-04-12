package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    String Sssss = "Moldova";
    int N = 14;
    @Override
    int getCountOfEggsPerMonth() {
        return N;
    }

    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Sssss+"."+" Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
