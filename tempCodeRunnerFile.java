import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private double balance = 5000; // Initial balance
    private int pin = 1234; // Default PIN
    private ArrayList<String> transactions = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("Incorrect PIN! Try again.");
            return;
        }

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    changePin();
                    break;
                case 5:
                    showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using our ATM!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
        transactions.add("Checked Balance: ₹" + balance);
    }

    private void withdrawMoney() {
        System.out.print("Enter withdrawal amount: ₹");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully!");
            transactions.add("Withdrawn: ₹" + amount);
        }
    }

    private void depositMoney() {
        System.out.print("Enter deposit amount: ₹");
        double amount = sc.nextDouble();
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully!");
        transactions.add("Deposited: ₹" + amount);
    }

    private void changePin() {
        System.out.print("Enter new PIN: ");
        int newPin = sc.nextInt();
        pin = newPin;
        System.out.println("PIN changed successfully!");
        transactions.add("PIN changed");
    }

    private void showTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet!");
        } else {
            System.out.println("Transaction History:");
            for (String t : transactions) {
                System.out.println("- " + t);
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}