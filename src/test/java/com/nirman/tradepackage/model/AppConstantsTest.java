package com.nirman.tradepackage.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppConstantsTest {
    @Test
    public void testAppConstants(){
        String currencyTypeSERConst = AppConstants.CURRENCY_TYPE_SER.getId();

        assertEquals("SAR",currencyTypeSERConst);
        assertEquals("AED",AppConstants.CURRENCY_TYPE_AED.getId());
        assertEquals("USD",AppConstants.TRADING_CURRENCE.getId());
        assertEquals("S",AppConstants.TRADING_TYPE_INCOMING.getId());
        assertEquals("B",AppConstants.TRADING_TYPE_OUTGOING.getId());


    }
}
