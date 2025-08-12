package OOPS;

public class Oops1 {
    static int passPercentage = 50;

    public static void main(String[] args) {

        Student karan = new Student();
        System.out.println(Oops1.passPercentage);

        passPercentage = 90;

    }

    public static void Greeting(){
        System.out.println("hello");
    }

}
// This is class that create a rule we use this to create different object
class Student {
    int age;
    String department;


    void Echo(){
        System.out.println("hello my age is "+ age);
    }

    Student(){
        this (12, "cse");
    }

    Student(int newage , String dept){
        age = newage;
        department = dept;
    }
}
