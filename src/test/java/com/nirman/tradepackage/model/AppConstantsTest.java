package com.nirman.tradepackage.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppConstantsTest {
    @Test
    public void testAppConstants(){
        String currencyTypeSERConst = AppConstants.CURRENCY_TYPE_SER.getId();

        assertEquals(currencyTypeSERConst,"SAR");
        assertEquals(AppConstants.CURRENCY_TYPE_AED.getId(),"AED");
        assertEquals(AppConstants.TRADING_CURRENCE.getId(),"USD");
        assertEquals(AppConstants.TRADING_TYPE_INCOMING.getId(),"S");
        assertEquals(AppConstants.TRADING_TYPE_OUTGOING.getId(),"B");


    }
}
