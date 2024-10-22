package banking;

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

            System.out.println("=== Savings Account Operations ===");
            savings.deposit(500.0);
            savings.withdraw(200.0);
            savings.calculateInterest();

            System.out.println("\n=== Checking Account Operations ===");
            checking.deposit(300.0);
            checking.withdraw(600.0);
            checking.calculateInterest();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
