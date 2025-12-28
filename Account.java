package com.bank.model;

public class Account {
private int accNo;
private String name;
private double balance;

public Account(int accNo, String name, double balance) {
	this.accNo = accNo;
	this.name = name;
	this.balance = balance;
}

public int getaccNO() {
	return accNo;
}

public String getname() {
	return name;
}

public double getbalance() {
	return balance;
}

public void setaccNo(int accNo) {
	this.accNo = accNo;
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

public void setAccNo(int accNo) {
	this.accNo = accNo;
}

@Override
public String toString() {
	return "Account [accNo=" + accNo + ", name=" + name + ", balance=" + balance + "]";
}


}
