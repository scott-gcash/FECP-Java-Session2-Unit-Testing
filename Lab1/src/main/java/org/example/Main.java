package org.example;

import java.util.*;

public class Main {
    public static void createAccount(ArrayList<BankAccount> bankAccounts, int number, String name, double balance){
        bankAccounts.add(new BankAccount(number, name, balance));
    }

    public static void viewAllAccounts(ArrayList<BankAccount> bankAccounts){
        for (int i = 0; i < bankAccounts.size(); i++){
            System.out.printf("Account %d: ", i+1);
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

    public static void deposit(ArrayList<BankAccount> bankAccounts, int index, double amount){
        bankAccounts.get(index).deposit(amount);
    }

    public static void withdraw(ArrayList<BankAccount> bankAccounts, int index, double amount){
        bankAccounts.get(index).withdraw(amount);
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
            System.out.println("Enter Choice (1-6): ");
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
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    break;
                default:
                    isExit = true;
                    break;
            }

            System.out.println("Would you like to return to the menu (yes/no): ");
            isReturnMenu = scanner.nextLine();

            if (isReturnMenu.equalsIgnoreCase("no")){
                isExit = true;
            }

        }while(isExit);
    }
}