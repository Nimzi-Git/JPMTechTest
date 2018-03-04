package com.nirman.tradepackage.model;

import com.nirman.tradepackage.service.impl.LoadTrades;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TradeTest {
    private static final String tradeFileName = "data.json";
    private static LoadTrades readTradeFile = new LoadTrades();
    @Test
    public void testTrade() throws IOException, ParseException {
        List<Trade> trades = (List<Trade>) readTradeFile.loadFiles(tradeFileName);

        String entityName;
        String tradedMethod;
        double  fxRate;
        String currency ;
        String instructionDate;
        String  settlementDate;
        String finalSettlDate;
        long  tradeUnits;
        double unitPrice;
        double tradeAmount;
        Trade trade = trades.get(0);
            trade.setFinalSettlDate("08 Jan 2016");
            trade.setTradeAmount(12345.45);
            entityName = trade.getEntityName();
            tradedMethod = trade.getTradedMethod();
            fxRate = trade.getFxRate();
            currency = trade.getCurrency();
            instructionDate=trade.getInstructionDate();
            settlementDate = trade.getSettlementDate();
            finalSettlDate = trade.getFinalSettlDate();
            tradeUnits = trade.getTradeUnits();
            unitPrice = trade.getUnitPrice();
            tradeAmount = trade.getTradeAmount();

            String stringVal =  trade.toString();
            String refString = "Trade{" +
                    "entityName='" + entityName + '\'' +
                    ", tradedMethod=" + tradedMethod +
                    ", fxRate=" + fxRate +
                    ", currency='" + currency + '\'' +
                    ", instructionDate='" + instructionDate + '\'' +
                    ", settlementDate='" + settlementDate + '\'' +
                    ", tradeUnits=" + tradeUnits +
                    ", unitPrice=" + unitPrice +
                    '}';
//
//
//                "Entity": "foo",
//                "TradeMetod": "B",
//                "AgreedFx": 0.50,
//                "Currency": "SGP",
//                "InstructionDate": "01 Jan 2016",
//                "SettlementDate": "02 Jan 2016",
//                "Units": 200,
//                "UnitPrice": 100.25
        assertEquals("foo",entityName);
        assertEquals("B", tradedMethod);
        assertEquals(0.50,fxRate,0.00);
        assertEquals("SGP",currency);
        assertEquals("01 Jan 2016",instructionDate);
        assertEquals("02 Jan 2016",settlementDate);
        assertEquals("08 Jan 2016",finalSettlDate);
        assertEquals(200,tradeUnits);
        assertEquals(100.25,unitPrice, 0.00);
        assertEquals(12345.45,tradeAmount,0.00);
        assertEquals(stringVal, refString);


    }
}

