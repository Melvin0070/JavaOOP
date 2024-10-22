package banking;

public abstract class BankAccount {
        private final String accountHolder;
        private final String accountNumber;
    private double balance;
    
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public abstract void calculateInterest();
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(String.format("Deposited: $%.2f. New balance: $%.2f", amount, balance));
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(String.format("Withdrawn: $%.2f. New balance: $%.2f", amount, balance));
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount or insufficient funds");
        }
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    protected void setBalance(double balance) {
        this.balance = balance;
    }
}