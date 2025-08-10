package OOPS;

public class Oops1 {

    public static void main(String[] args) {
//        Student[] it; // declaring the array of students object that pointing to the Student class
//        it = new Student[5];
//        System.out.println(it[1]);

        int age = 5;



            Student karan = new Student();
            Student leena = karan;


            System.out.println(leena.age);
            System.out.println(leena.department);
            karan.Echo();


        }

    // This is class that create a rule we use this to create different object




}

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
