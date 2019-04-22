package com.sys.tryxx.StrategyModel;


public class CashDec extends CashFactory {
    private double cash;
    private double moneyDec;

    public CashDec(double cash, double moneyDec) {
        this.cash = cash;
        this.moneyDec = moneyDec;
    }

    @Override
    public double getCashStra(double money) {
        return money - Math.floor(money/cash)*moneyDec;
    }
}
