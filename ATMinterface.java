import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ", New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

class ATM {
    private BankAccount account;
    private int pin;
    private Scanner scanner;

    public ATM(BankAccount account, int pin) {
        this.account = account;
        this.pin = pin;
        this.scanner = new Scanner(System.in);
    }

    public boolean validatePIN() {
        System.out.print("Enter your 4-digit PIN: ");
        int enteredPIN = scanner.nextInt();
        return enteredPIN == pin;
    }

    public void start() {
        if (!validatePIN()) {
            System.out.println("Invalid PIN. Exiting...");
            return;
        }

        int choice;

        do {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 4);
    }
}

public class ATMinterface {
    public static void main(String[] args) {
        double initialBalance = 1000.0;
        int pin = 1234;
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount, pin);

        atm.start();
    }
}
