package banking;

import java.time.LocalDate;

public class BankingDemo {
    public static void main(String[] args) {
        try {
            SavingsAccount savings = new SavingsAccount(
                    "John Doe",
                    "SA001",
                    1000.0,
                    0.05);

            CheckingAccount checking = new CheckingAccount(
                    "Jane Doe",
                    "CA001",
                    500.0,
                    100.0);

            FixedDepositAccount fixedDeposit = new FixedDepositAccount(
                    "Alice Smith",
                    "FD001",
                    5000.0,
                    0.07,
                    LocalDate.of(2025, 10, 25) 
            );

            System.out.println("=== Savings Account Operations ===");
            savings.deposit(500.0);
            savings.withdraw(200.0);
            savings.calculateInterest();

            System.out.println("\n=== Checking Account Operations ===");
            checking.deposit(300.0);
            checking.withdraw(600.0);
            checking.calculateInterest();
            System.out.println("\n=== Fixed Deposit Account Operations ===");
            fixedDeposit.calculateInterest();
            try {
                fixedDeposit.withdrawAfterMaturity(1000.0);
            } catch (IllegalArgumentException e) {
                System.out.println("Withdrawal attempt failed: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}