package OOPS.Inheritance;

public class Expense {
    static int totalWealth = 50000;
    Expense(){
        System.out.println("hello");
    }
    Expense(int spent){
        Expense.totalWealth -= spent;
    }

    public static void checkWealth(){
        System.out.println("Total amount is " + Expense.totalWealth);
    }

}
