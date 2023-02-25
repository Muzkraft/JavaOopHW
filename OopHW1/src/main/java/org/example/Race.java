package org.example;

import java.util.Random;

public class Race {
    private final String track;
    private final double distance;
    private final int stages;
    static Random rnd = new Random();

    Race(String track, int distance, int stages) {
        this.track = track;
        this.distance = distance;
        this.stages = stages;
    }

    public void getInfo() {
        System.out.println("Трасса: " + track + ", дистанция: " + distance + ", " + stages + " этапов\n");
    }

    static void onStart(Car car1, Car car2) throws InterruptedException {
        System.out.println("На старт!\n");
        Thread.sleep(1000);
        car1.startEngine(car1);
        car2.startEngine(car2);
        System.out.println();
        Thread.sleep(1000);
        System.out.println("Внимание...");
        System.out.println();
        Thread.sleep(1000);
        System.out.println("Поехали!\n");
    }

    static double driving(Car car, Race track) {
        double time = 0;
        double start = 0;
        double currentDistance = track.distance / track.stages;
        if (car.isStarted) {
            while (start < track.distance) {
                for (int i = 1; i <= track.stages; i++) {
                    double stageTime;
                    int currentSpeed = (int) (rnd.nextDouble(10 * car.getVelocity(), car.getMaxSpeed()) / 3.6);
                    stageTime = currentDistance / currentSpeed;
                    start += stageTime * currentSpeed;
                    System.out.printf("Этап: " + i + ", Время: " + "%.2f", stageTime);
                    System.out.println();
                    time += stageTime / 60;
                }
            }
        } else {
            System.out.println("Заведи двигатель сначала!");
        }
        System.out.printf("Время машины " + car.getModel() + ": " + "%.2f", time);
        System.out.println();
        return car.setRaceTime(time);
    }
}
