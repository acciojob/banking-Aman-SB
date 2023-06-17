package com.driver;

import java.util.UUID;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
//        Each digit of an account number can lie between 0 and 9 (both inclusive)
//        Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
//        If it is not possible, throw "Account Number can not be generated" exception

        if (digits <= 0 || sum < 0 || sum > digits * 9) {
            throw new RuntimeException("Account Number cannot be generated");
        }

        int[] accountNumber = new int[digits];
        int remainingSum = sum;

        // Generate the account number digits
        for (int i = 0; i < digits; i++) {
            if (remainingSum >= 9) {
                accountNumber[i] = 9;
                remainingSum -= 9;
            } else {
                accountNumber[i] = remainingSum;
                remainingSum = 0;
            }
        }

        // If there's still a remaining sum, it's not possible to generate the account number
        if (remainingSum > 0) {
            throw new RuntimeException("Account Number cannot be generated");
        }

        // Convert the account number digits to an integer
        int generatedAccountNumber = 0;
        for (int i = 0; i < digits; i++) {
            generatedAccountNumber = generatedAccountNumber * 10 + accountNumber[i];
        }

        return String.valueOf(generatedAccountNumber);
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance - amount < minBalance){
            throw new RuntimeException("Insufficient Balance");
        }

        this.balance-=amount;
    }

}