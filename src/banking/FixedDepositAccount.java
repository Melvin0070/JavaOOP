package banking;

import java.time.LocalDate;

public class FixedDepositAccount extends BankAccount {
    private double interestRate;
    private LocalDate maturityDate;

    public FixedDepositAccount(String accountHolder, String accountNumber, double initialBalance,
                               double interestRate, LocalDate maturityDate) {
        super(accountHolder, accountNumber, initialBalance);
        this.interestRate = interestRate;
        this.maturityDate = maturityDate;
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println(String.format("Interest added: $%.2f. New balance: $%.2f",
                interest, getBalance()));
    }

    // Method to check if the account has matured
    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate);
    }

    // Special method to withdraw funds after maturity
    public void withdrawAfterMaturity(double amount) {
        if (!isMatured()) {
            throw new IllegalArgumentException("Cannot withdraw until maturity. Maturity date: " + maturityDate);
        }
        if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        setBalance(getBalance() - amount);
        System.out.println(String.format("Withdrawn after maturity: $%.2f. New balance: $%.2f",
                amount, getBalance()));
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }
}