package OOPS.Practice;

public class Vehicle {
    void start(){
        System.out.println("dru dru started");
    }
}

class Car extends Vehicle{
    @Override
    void start(){
        System.out.println("car started");
    }
}

class Bike extends Vehicle{
    void start(){
        System.out.println("bike started");
    }
}

class Main{
    public static void main(String[] args) {
        Vehicle ninja = new Car();
        ninja.start();
    }
}


