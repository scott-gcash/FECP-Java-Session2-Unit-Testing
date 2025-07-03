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
        System.out.printf("Account Number: %d", this.accountNumber);
        System.out.printf("Bank Holder Name: %s", this.bankAccountHolderName);
        System.out.printf("Available Balance: %f", this.availableBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankAccountHolderName() {
        return bankAccountHolderName;
    }

    public void setBankAccountHolderName(String bankAccountHolderName) {
        this.bankAccountHolderName = bankAccountHolderName;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }
}
