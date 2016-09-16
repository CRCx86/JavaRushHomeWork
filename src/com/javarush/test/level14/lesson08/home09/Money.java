package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private Double aDouble;

    public Money(double amount)
    {
        this.aDouble = amount;
    }

    protected Money() {
    }

    public double getAmount() {
        return this.aDouble;
    }

    public abstract String getCurrencyName();
}

