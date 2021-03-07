package com.company;

public class Application {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.makeSportsCar(builder);
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.makeSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
