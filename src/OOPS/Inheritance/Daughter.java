package OOPS.Inheritance;

public class Daughter extends Expense{
    Daughter () {
        System.out.println("daughter class");
    }

    public static void main(String[] args) {
        Daughter sow = new Daughter();
        Daughter.checkWealth();
    }
}
