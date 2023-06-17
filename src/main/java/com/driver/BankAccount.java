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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
//        Each digit of an account number can lie between 0 and 9 (both inclusive)
//        Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
//        If it is not possible, throw "Account Number can not be generated" exception

        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        int convertedNumber = convertUUIDToString(uuidString);
        return String.valueOf(convertedNumber);
    }

    public static int convertUUIDToString(String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();

        // Combine the most significant and least significant bits and take the absolute value
        long combinedBits = mostSignificantBits ^ leastSignificantBits;
        long absoluteValue = Math.abs(combinedBits);

        // Map the absolute value to a number between 0 and 9
        int convertedNumber = (int) (absoluteValue % 10);

        return convertedNumber;
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