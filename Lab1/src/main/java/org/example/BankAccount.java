package org.example;

public class BankAccount {
    private int accountNumber;
    private String bankAccountHolderName;
    private double availableBalance;

    BankAccount(){
    }

    BankAccount(int number, String name, double balance){
        this.accountNumber = number;
        this.bankAccountHolderName = name;
        this.availableBalance = balance;
    }

    public void deposit(double balance){
        if (balance > 0) {
            this.availableBalance += balance;
        }
    }

    public void withdraw(double amount){
        if (amount <= this.availableBalance && amount > 0){
            this.availableBalance -= amount;
        }
    }

    public void displayInformation(){
        System.out.printf("Account Number: %d\n", this.accountNumber);
        System.out.printf("Bank Holder Name: %s\n", this.bankAccountHolderName);
        System.out.printf("Available Balance: %f\n", this.availableBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
