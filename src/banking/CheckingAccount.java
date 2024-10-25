package banking;

public class CheckingAccount extends BankAccount implements Withdrawable {
    private double creditLimit;
    private static final double CHECKING_INTEREST_RATE = 0.001;

    public CheckingAccount(String accountHolder, String accountNumber,
                           double initialBalance, double creditLimit) {
        super(accountHolder, accountNumber, initialBalance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * CHECKING_INTEREST_RATE;
        setBalance(getBalance() + interest);
        System.out.println(String.format("Interest added: $%.2f. New balance: $%.2f",
                interest, getBalance()));
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance() + creditLimit) {
            throw new IllegalArgumentException("Amount exceeds overdraft limit");
        }
        setBalance(getBalance() - amount);
        System.out.println(String.format("Withdrawn: $%.2f. New balance: $%.2f",
                amount, getBalance()));
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
