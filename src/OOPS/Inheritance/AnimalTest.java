package OOPS.Inheritance;
/*

Q2. Inheritance

Create a class Animal with sound() method.

Inherit Dog and Cat classes and override the sound() method.

Call them polymorphically like:

Animal a = new Dog();
a.sound(); // Should print "Woof"
 */
public class AnimalTest {

    public void sound(){
        System.out.println("animal sound");
    }
}

class DogTest extends AnimalTest{

    public void sound(){
        System.out.println("helly");
    }
    public static void main(String[] args) {
        AnimalTest pupppy = new DogTest();
        pupppy.sound();
    }
}


