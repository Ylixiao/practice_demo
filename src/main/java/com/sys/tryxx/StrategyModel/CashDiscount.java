package com.sys.tryxx.StrategyModel;


public class CashDiscount extends CashFactory {
    private double discount;

    public CashDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getCashStra(double money) {
        return money*discount;
    }
}
