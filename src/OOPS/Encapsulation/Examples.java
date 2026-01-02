package OOPS.Encapsulation;



class Examples {
    // Private fields (data hiding)
    private String accountNumber;
    private double balance;
    private String ownerName;

    // Constructor
    public Examples(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    // Public getter methods
    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // Public setter methods with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Examples account = new Examples("123456", "John Doe");
        System.out.println(account.accountNumber);
        account.deposit(1000);
        System.out.println("Balance: $" + account.getBalance()); // $1000.0
        account.withdraw(500);
        System.out.println("Balance: $" + account.getBalance()); // $500.0

        // account.balance = 1000000; // Error: balance is private
    }
}
