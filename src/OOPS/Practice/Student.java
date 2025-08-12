package OOPS.Practice;

public class Student {
    // Static variable (shared by all students)
    static int totalStudents = 0;

    // Non-static variable (unique for each student)
    String name;

    // Constructor (runs when object is created)
    public Student(String studentName) {
        name = studentName;    // assign name
        totalStudents++;       // increase count
        System.out.println("Student Created: " + name);
    }

    // Non-static method (needs object)
    public void showName() {
        System.out.println("My name is " + name);
    }

    // Static method (can be used without object)
    public static void showTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
}
