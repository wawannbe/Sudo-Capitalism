package com.sudocapitalism.company;

public class Company {

    private double money;
    private String name;

    public Company() {
        this.name = "NoNameCorp";
        this.money = 2000.0;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double amount) {
        this.money += amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
