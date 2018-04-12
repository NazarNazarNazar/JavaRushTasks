package com.javarush.task.task25.task2506;

class LoggingStateThread extends Thread {
    Thread targetThread;

    public LoggingStateThread(Thread target) {
        this.targetThread = target;
    }

    @Override
    public void run() {
        State oldState = this.targetThread.getState();
        System.out.println(oldState);
        while (oldState != State.TERMINATED) {
            if(oldState != this.targetThread.getState()) {
                oldState = this.targetThread.getState();
                System.out.println(oldState);
            }

        }
    }
}
