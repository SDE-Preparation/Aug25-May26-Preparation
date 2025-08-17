package OOPS.Abstraction;


// Abstract class
abstract class Vehicle {
    // Abstract method (no implementation)
    abstract void start();

    // Normal method (with implementation)
    void stop() {
        System.out.println("Vehicle stopped.");
    }
}

// Child class
class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with key ignition.");
    }
}

// Another child
class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike starts with self start button.");
    }
}

public class Learning {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        v1.start();  // Car-specific
        v1.stop();   // Common method

        Vehicle v2 = new Bike();
        v2.start();  // Bike-specific
        v2.stop();   // Common method
    }
}
