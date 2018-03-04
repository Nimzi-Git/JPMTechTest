package com.nirman.tradepackage.model;

public enum AppConstants {

    TRADING_CURRENCE("USD"),
    TRADING_TYPE_INCOMING("S"),
    TRADING_TYPE_OUTGOING("B"),
    CURRENCY_TYPE_AED("AED"),
    CURRENCY_TYPE_SER("SAR")

    ;


   private final String id;
    AppConstants(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
