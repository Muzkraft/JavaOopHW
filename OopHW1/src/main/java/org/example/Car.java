package org.example;

/*Доработайте программу в свободном стиле.
Можно сравнить 2 автомобиля между собой
Или пусть авто заедет за фруктами :-)
Добавьте несколько произвольных методов и свойств
<br>
ДОП: Сделать гонки:
- задаём растояние
- едут до финиша.
Сказать кто победит.*/
public class Car {
    private final String model;
    private final int year;
    private double price;
    public String color;
    private final int power;
    boolean isStarted = false;
    private int maxSpeed;
    private final double velocity;
    private double raceTime;

    Car(String model, int year, double price, String color, int power, int maxSpeed, double velocity) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.velocity = velocity;
    }
    public void getInfo() {
        System.out.println("Модель: "+ model +
                "\nГод выпуска: " + year +
                "\nМощность двигателя: " + power +
                "\nМаксимальная скорость: " + maxSpeed +
                "\nЦвет кузова: " + color +
                "\nЦена: " + price + "\n");
    }
    public void startEngine(Car car) {
        if (!isStarted) {
            this.isStarted = true;
            System.out.println("Автомобиль " + car.model + " заведен");
        }
    }
    public void stopEngine(Car car) {
        if (isStarted) {
            this.isStarted = false;
            System.out.println("Двигатель " + car.model + " заглушен\n");
        }
    }
    public double getRaceTime() {
        return raceTime;
    }
    public double setRaceTime(double time) {
        return raceTime = time;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int value) {
        maxSpeed = value;
    }
    public String getModel() {
        return model;
    }
    public double getVelocity() {
        return velocity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double value) {
         price = value;
    }
}
