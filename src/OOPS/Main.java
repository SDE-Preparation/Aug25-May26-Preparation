package OOPS;

import OOPS.Practice.Student; // Importing our package

public class Main {
    public static void main(String[] args) {
        // Creating objects (constructor will run)
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Calling non-static method using object
        s1.showName();
        s2.showName();

        // Calling static method using class name
        Student.showTotalStudents();
    }
}
