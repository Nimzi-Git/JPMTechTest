package com.nirman.tradepackage.service.impl;

import com.nirman.tradepackage.model.CalculateFinalSettlmetDate;
import com.nirman.tradepackage.model.Trade;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenerateReportTest {
    private static List<Trade> incommingTrades = new ArrayList<>();
    private static List<Trade> outgoingTrades = new ArrayList<>();
    private static final String tradeFileName = "data.json";
    private static LoadTrades readTradeFile = new LoadTrades();

    @Test
    public void testGenerateReportTest() throws IOException, ParseException {
        CalculateFinalSettlmetDate calculateFinalSettlmetDate = new CalculateFinalSettlmetDate();
        GenerateReportImpl generateReportObj = new GenerateReportImpl();

        List<Trade> trades = (List<Trade>) readTradeFile.loadFiles(tradeFileName);
         Trade trade = trades.get(0);

             StringBuilder result = new StringBuilder();
             result.append("PRINTING " + "FULL" + " TRADE REPORT");
             result.append("\n");
             result.append("===================================================================================================================================================");
             result.append("\n");
             result.append("ENTITY--|--BUY/SELL--|--AgreedFX--|--Currency--|--Instruction Date--|--Settlement Date--|--Final Settlement Date--|--Units--|--Price Per Unit--|--" +
                     "Total Trade Price");
             result.append("\n");
             result.append("----------------------------------------------------------------------------------------------------------------------------------------------------");
             result.append("\n");
             for (Trade trade1 : trades) {
                 result.append(trade1.getEntityName() + "   --|--   " + trade1.getTradedMethod() + "    --|--    " + String.format("%.2f", trade1.getFxRate()) + " --|--  " + trade1.getCurrency()
                         + "   --|--   " + trade1.getInstructionDate() + "  --|--      " + trade1.getSettlementDate() + " --|-- " + trade1.getFinalSettlDate()
                         + "    --|--  " + trade1.getTradeUnits() + " --|--  " + String.format("%.2f", trade1.getUnitPrice())
                         + "     --|--  USD " + String.format("%.2f", trade1.getTradeAmount()));
                 result.append("\n");
             }
             //result.append(" ");



        calculateFinalSettlmetDate = generateReportObj.isTradable(trade.getSettlementDate(), trade.getCurrency());
        StringBuilder sb =generateReportObj.generateFullTradeReport(trades,"FULL");


        generateReportObj.generateReport(trade);
        System.out.println("OUTGOING TRADES"+generateReportObj.getOutgoingTrades().size());
        System.out.println("INCOMING TRADES"+generateReportObj.getIncommingTrades().size());
        assertEquals(calculateFinalSettlmetDate.getNewSettlementDate().toString(),"2016-01-04");
        assertEquals(calculateFinalSettlmetDate.getTradable(),false);
        assertEquals(String.format("%.2f",trade.getTradeAmount()), "10025.00");
        assertEquals(generateReportObj.getOutgoingTrades().size(),1);
        assertEquals(generateReportObj.getIncommingTrades().size(),0);
        assertEquals((sb.toString()).equals(result.toString()),true);



    }
}
