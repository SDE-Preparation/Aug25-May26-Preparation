package OOPS.Encapsulation;

/*
* Create a BankAccount class with:

private balance field

deposit(amount) and withdraw(amount) methods

Getter for balance

👉 Try to make deposit reject negative amounts and withdraw reject if balance is too low.
* */
public class BankAccount {

    private int balance;

    public void getter(){
        System.out.println("balance" + this.balance);
    }

    public void deposit(int amount){

        if(amount < 1){
            System.out.println("Enter valid amount ex. above 1 rupees");
        }else{
            this.balance += amount;

            System.out.println("Amount deposited");
        }


    }

    public void withdraw(int amount){
        if(amount > this.balance){
            System.out.println("Balance is too low");;
        }else{

            this.balance -= amount;

            System.out.println("Amount withdraw successfuly");
        }

    }

    public static void main(String[] args) {
        BankAccount person1 = new BankAccount();

        person1.deposit(100);
        person1.getter();
        person1.withdraw(2);
        person1.getter();
        person1.deposit(500000);
        person1.getter();
    }
}
