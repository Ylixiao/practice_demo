package com.sys.tryxx.StrategyModel;

public class CashContext {
    CashFactory cs = null;

    public CashContext(String type){
        switch (type){
            case "正常":
                cs = new CashNormal();
                break;
            case "几几折扣":
                cs = new CashDiscount(0.8);
                break;
            case "满减":
                cs = new CashDec(200,60);
                break;

        }
    }

    public double getTotal(double money){
        return cs.getCashStra(money);
    }
}
