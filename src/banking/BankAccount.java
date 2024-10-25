package banking;

public abstract class BankAccount implements InterestCalculator {
    private final String accountHolder;
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // OCP: No need to modify this method for new types of accounts.
    // Polymorphism (Runtime): Subclasses override this to calculate interest differently.
    @Override
    public abstract void calculateInterest(); 

    // SRP: Responsibility of deposit logic only
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(String.format("Deposited: $%.2f. New balance: $%.2f", amount, balance));
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    // LSP: Subclasses may override this method but must maintain its contract (valid amount).
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(String.format("Withdrawn: $%.2f. New balance: $%.2f", amount, balance));
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount or insufficient funds");
        }
    }

    // SRP: Responsibility of handling account holder information is isolated here
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {  // LSP: Safe to extend, controls access to balance.
        this.balance = balance;
    }
}

