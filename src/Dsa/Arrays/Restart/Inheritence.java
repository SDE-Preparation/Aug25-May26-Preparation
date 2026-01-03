package Dsa.Arrays.Restart;



// Base class (Parent class)
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// Derived class (Child class)
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent constructor
        this.breed = breed;
    }

    // Additional method
    public void bark() {
        System.out.println(name + " is barking.");
    }

    // Method overriding
    @Override
    public void eat() {
        System.out.println(name + " the dog is eating dog food.");
    }
}

// Another derived class
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow() {
        System.out.println(name + " says meow!");
    }

    @Override
    public void eat() {
        System.out.println(name + " the cat is eating fish.");
    }
}

public class Inheritence {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2);

        dog.eat();      // Buddy the dog is eating dog food.
        dog.sleep();    // Buddy is sleeping.
        dog.bark();     // Buddy is barking.

        cat.eat();      // Whiskers the cat is eating fish.
        cat.sleep();    // Whiskers is sleeping.
        cat.meow();     // Whiskers says meow!
    }
}