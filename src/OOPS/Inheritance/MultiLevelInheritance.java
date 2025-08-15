package OOPS.Inheritance;



class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    void sound() {
        System.out.println("Dog barks");
    }
}



public class MultiLevelInheritance {
    public static void main(String[] args) {
        Animal dog = new Dog(); // Parent reference, child object
        dog.sound();

    }
}
