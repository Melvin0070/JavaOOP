package banking;

public class SavingsAccount extends BankAccount implements Withdrawable {

    private double interestRate;
    private static final double MINIMUM_BALANCE = 100.0;

    public SavingsAccount(String accountHolder, String accountNumber,
                          double initialBalance, double interestRate) {
        super(accountHolder, accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println(String.format("Interest added: $%.2f. New balance: $%.2f",
                interest, getBalance()));
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < MINIMUM_BALANCE) {
            throw new IllegalArgumentException(
                    "Withdrawal would put balance below minimum requirement of $" + MINIMUM_BALANCE);
        }
        setBalance(getBalance() - amount);
        System.out.println(String.format("Withdrawn: $%.2f. New balance: $%.2f",
                amount, getBalance()));
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}