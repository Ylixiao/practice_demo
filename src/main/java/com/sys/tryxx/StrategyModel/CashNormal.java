package com.sys.tryxx.StrategyModel;

public class CashNormal extends CashFactory {
    @Override
    public double getCashStra(double money) {
        return money;
    }
}
