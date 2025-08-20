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

    public static int hello(){
        return 10;
    }
    public static void main(String[] args) {


        System.out.println(hello());

    }
}
