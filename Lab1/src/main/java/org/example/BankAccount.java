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
            return;
        }

        System.out.println("Invalid Deposit! Amount should be greater than 0.");
    }

    public void withdraw(double amount){
        if (amount < 0 || amount > availableBalance){
            System.out.println("Invalid Withdraw! Amount should be greater than 0 or not greater than your current balance.");
            return;
        }

        this.availableBalance -= amount;
    }

    public void displayInformation(){
        System.out.printf("Account Number: %d\n", this.accountNumber);
        System.out.printf("Bank Holder Name: %s\n", this.bankAccountHolderName);
        System.out.printf("Available Balance: %.2f\n", this.availableBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
