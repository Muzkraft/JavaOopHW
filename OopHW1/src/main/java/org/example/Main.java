package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Car car1 = new Car("Hyundai", 2008, 1000000, "grey", 149, 220, 4);
        Car car2 = new Car("Mazda", 2010, 2000000, "red", 130, 250, 5);
        Race track1 = new Race("Monaco", 5000, 5);
        car1.setPrice(500000);
        car1.setMaxSpeed(300);
        System.out.println(car1.getPrice());
        car1.getInfo();
        car2.getInfo();
        track1.getInfo();

        Race.onStart(car1, car2);
        Race.driving(car1, track1);
        Race.driving(car2, track1);

        car1.stopEngine(car1);
        car2.stopEngine(car2);

        if (car1.getRaceTime() < car2.getRaceTime()) {
            System.out.printf("В заезде побеждает " + car1.getModel() + " c временем " + "%.2f", car1.getRaceTime());
        } else {
            System.out.printf("В заезде побеждает " + car2.getModel() + " c временем " + "%.2f", car2.getRaceTime());
        }
    }
}