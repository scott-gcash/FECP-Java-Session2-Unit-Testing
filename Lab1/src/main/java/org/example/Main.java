package org.example;

import java.util.*;

public class Main {
    public static void createAccount(ArrayList<BankAccount> bankAccounts, int number, String name, double balance){
        bankAccounts.add(new BankAccount(number, name, balance));
    }

    public static void viewAllAccounts(ArrayList<BankAccount> bankAccounts){
        for (int i = 0; i < bankAccounts.size(); i++){
            System.out.printf("Account %d: \n", i+1);
            bankAccounts.get(i).displayInformation();
        }
    }

    public static void checkBalance(ArrayList<BankAccount> bankAccounts, int accountNumber){
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                bankAccount.displayInformation();
                return;
            }
        }
        System.out.println("Account Number not found!");
    }

    public static void deposit(ArrayList<BankAccount> bankAccounts, int accountNumber, double amount){
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                bankAccount.deposit(amount);
                return;
            }
        }
        System.out.println("Account Number not found!");
    }

    public static void withdraw(ArrayList<BankAccount> bankAccounts, int accountNumber, double amount){
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                bankAccount.withdraw(amount);
                return;
            }
        }
        System.out.println("Account Number not found!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        int choice;
        boolean isExit = false;
        String isReturnMenu;

        do{
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter Choice (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    int accountNumber;
                    String accountName;
                    double initialDeposit = 0;
                    String isInitialDeposit;

                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Holder Name: ");
                    accountName = scanner.nextLine();

                    System.out.print("Initial Deposit? (yes/no)");
                    isInitialDeposit = scanner.nextLine();

                    if (isInitialDeposit.equalsIgnoreCase("yes")){
                        System.out.print("Enter initial deposit amount: ");
                        initialDeposit = scanner.nextInt();
                        scanner.nextLine();
                    }

                    System.out.println("Account Created Successfully");
                    createAccount(bankAccounts, accountNumber, accountName, initialDeposit);

                    break;
                case 2:
                    viewAllAccounts(bankAccounts);
                    break;
                case 3:
                    int searchAccountNumber;
                    System.out.print("Enter Account Number: ");
                    searchAccountNumber = scanner.nextInt();
                    scanner.nextLine();

                    checkBalance(bankAccounts, searchAccountNumber);

                    break;
                case 4:
                    int depositAccountNumber, depositAmount;
                    System.out.print("Enter Account Number: ");
                    depositAccountNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Deposit Amount: ");
                    depositAmount = scanner.nextInt();
                    scanner.nextLine();

                    deposit(bankAccounts, depositAccountNumber, depositAmount);
                    break;
                case 5:
                    int withdrawAccountNumber, withdrawAmount;
                    System.out.print("Enter Account Number: ");
                    withdrawAccountNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Withdraw Amount: ");
                    withdrawAmount = scanner.nextInt();
                    scanner.nextLine();

                    withdraw(bankAccounts, withdrawAccountNumber, withdrawAmount);
                    break;
                default:
                    isExit = true;
                    break;
            }

            if (isExit) break;

            System.out.println("Would you like to return to the menu (yes/no): ");
            isReturnMenu = scanner.nextLine();

            if (isReturnMenu.equalsIgnoreCase("no")){
                isExit = true;
            }

        }while(!isExit);
    }
}