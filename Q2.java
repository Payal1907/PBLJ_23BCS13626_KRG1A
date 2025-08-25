 class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        setBalance(initialBalance);
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double amount) {
        if (amount >= 0) {
            this.balance = amount;
            System.out.println("Balance set to: $" + amount);
        } else {
            System.out.println("Error: Balance cannot be negative!");
        }
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Error: Deposit amount must be positive!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive!");
        } else {
            System.out.println("Error: Insufficient balance! Available: $" + balance);
        }
    }
    
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber + " | Balance: $" + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        System.out.println("=== BankAccount Encapsulation Demo ===\n");
        BankAccount account = new BankAccount("ACC123456", 1000.0);
        
        // initial account information
        System.out.println("Initial Account Info:");
        account.displayAccountInfo();
        System.out.println();
        
        // Perform deposit
        System.out.println("--- Deposit Operations ---");
        account.deposit(500.0);  // Valid deposit
        account.deposit(-100.0); // Invalid deposit (negative amount)
        account.deposit(0);      // Invalid deposit (zero amount)
        System.out.println();
        
        // Perform withdrawal
        System.out.println("--- Withdrawal Operations ---");
        account.withdraw(200.0);  // Valid withdrawal
        account.withdraw(2000.0); // Invalid withdrawal (insufficient balance)
        account.withdraw(-50.0);  // Invalid withdrawal (negative amount)
        System.out.println();
        
        // setBalance method with validations
        System.out.println("--- Balance Setting Operations ---");
        account.setBalance(800.0);  // Valid balance
        account.setBalance(-200.0); // Invalid balance (negative)
        System.out.println();
        
        // final balance
        System.out.println("--- Final Account Status ---");
        System.out.println("Final Balance: $" + account.getBalance());
        account.displayAccountInfo();
        System.out.println();
        
        // showing encapsulation - these lines would cause compilation errors
        System.out.println("--- Encapsulation Demonstration ---");
        System.out.println("The following lines are commented out because they would cause compilation errors:");
        System.out.println("// account.balance = 5000.0;  // Error: balance has private access");
        System.out.println("// System.out.println(account.balance);  // Error: balance has private access");
        System.out.println("// account.accountNumber = \"HACKED\";  // Error: accountNumber has private access");
    }
}
