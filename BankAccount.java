import java.util.Scanner;

//while (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5) {

public class BankAccount {
    String AccountHolderName;
    float balance;

    public static void main(String... args) {
        System.out.println("Welcome to Simple Bank System");

        // Setup for new account
        BankAccount newAccount = null;
        newAccount = new BankAccount();
        createAccount(newAccount);

        while (true) {
            try {
                // Get initial menu input from user
                Scanner Menu = new Scanner(System.in);
                int menuInput = 0;
                System.out.print("1. Create New Account\n2. Deposit Money\n3. Withdraw Money\n4. Check Balance\n5. Exit\n\nEnter your choice: ");
                menuInput = Menu.nextInt();
                
                switch (menuInput) {
                    // Create Account
                    case 1:
                        // Initialize the new account
                        newAccount = new BankAccount();
                        createAccount(newAccount);
                        break;
        
                    // Deposit Money
                    case 2:
                        depositMoney(newAccount);
                        break;
        
                    // Withdraw Money
                    case 3:
                        withdrawMoney(newAccount);
                        break;
        
                    // Check Balance
                    case 4:
                        displayBalance(newAccount);
                        break;
        
                    // Exit Program
                    case 5:
                        exit();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Please check your input and try again.");
            }
        }
    }

    public static void createAccount(BankAccount newAccount) {
        // Initialize the new account's attributes with user's input
        Scanner Menu = new Scanner(System.in);

        System.out.print("Enter account name: ");
        String accountName = Menu.nextLine();
        newAccount.AccountHolderName = accountName;

        System.out.print("Enter initial deposit: ");
        float initialDeposit = Menu.nextFloat();
        newAccount.balance = initialDeposit;
        System.out.println("Deposit Successful! New balance: $" + newAccount.balance + "\n");
    }

    public static void depositMoney(BankAccount newAccount) {
        // Make deposit with user's input
        float depositAmount = -1;
        while (depositAmount < 0) {
            // Get user's input
            Scanner Menu = new Scanner(System.in);
            System.out.print("Enter amount to deposit: ");
            depositAmount = Menu.nextFloat();
            // Error check
            if (depositAmount < 0) {
                System.out.println("Please input a positive number.");
            }
        }

        newAccount.balance += depositAmount;
        System.out.println("Deposit Successful! New balance: $" + newAccount.balance + "\n");
    }

    public static void withdrawMoney(BankAccount newAccount) {
        // Make withdrawal with user's input
        float withdrawalAmount = -1;
        while (withdrawalAmount < 0) {
            // Get user's input
            Scanner Menu = new Scanner(System.in);
            System.out.print("Enter amount to withdraw: ");
            withdrawalAmount = Menu.nextFloat();
            // Error check
            if (withdrawalAmount < 0) {
                System.out.println("Please input a positive number.");
            }
        }

        // Insufficient funds check
        if (withdrawalAmount > newAccount.balance) {
            System.out.println("Insufficient funds!" + "\n");
            return;
        }

        newAccount.balance -= withdrawalAmount;
        System.out.println("Withdrawal Successful! New balance: $" + newAccount.balance + "\n");
    }

    public static void displayBalance(BankAccount newAccount) {
        System.out.println("Current balance: $" + newAccount.balance + "\n");
    }

    public static void exit() {
        System.out.println("Thank you for using Simple Bank System!");
        System.exit(0);
    }

}