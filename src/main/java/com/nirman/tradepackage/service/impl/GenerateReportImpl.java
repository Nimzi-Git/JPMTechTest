package com.nirman.tradepackage.service.impl;

import com.nirman.tradepackage.model.AppConstants;
import com.nirman.tradepackage.model.CalculateFinalSettlmetDate;
import com.nirman.tradepackage.model.Trade;
import com.nirman.tradepackage.serviceI.GenerateReport;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.time.DayOfWeek.*;

public class GenerateReportImpl implements GenerateReport {

    private static List<Trade> incommingTrades = new ArrayList<>();
    private static List<Trade> outgoingTrades = new ArrayList<>();



    @Override
    public void generateReport(List<Trade> trades) {

        for (Trade trade : trades) {
            //Generating trade data
            generateReport(trade);
        }


        //Pring full Report
        printReport(trades, "FULL");

        //Print Report of Incoming Trades ranked by the trade amount for dates
        printReport(incommingTrades, "RANKED ENTITIES BASED ON INCOMING");


        //Print Report of Outgoing Trades ranked by the trade amount for dates
        printReport(outgoingTrades, "RANKED ENTITIES BASED ON OUTGOING");
    }

    private void printReport(List<Trade> trades, String messages) {
        trades.sort(Comparator.comparing(Trade::getFinalSettlDate).thenComparing(Trade::getTradeAmount).reversed());
        StringBuilder inCommingReport = generateFullTradeReport(trades, messages);
        System.out.println(inCommingReport);
    }


    public void generateReport(Trade trade){

            //Check Tradable and Settlement Date
            CalculateFinalSettlmetDate finalSettlementSituation = isTradable(trade.getSettlementDate(), trade.getCurrency());

            //Set Final Settlement Date
            trade.setFinalSettlDate(finalSettlementSituation.getNewSettlementDate().format(DateTimeFormatter.ofPattern("dd MMM YYYY")));

            //Calculate Trade Amount
            calculateTradeAmount(trade);

            //Populate Outgoing and Incoming Trades
            if(trade.getTradedMethod().equals(AppConstants.TRADING_TYPE_INCOMING.getId())){
                incommingTrades.add(trade);
            }
            else
            {
                outgoingTrades.add(trade);
            }

        }

    //Calculate Fina Settlement date based on the currency
   public CalculateFinalSettlmetDate isTradable(String dateInString, String currency){
        CalculateFinalSettlmetDate calcFinalSettlmnt = new CalculateFinalSettlmetDate();
        Boolean isSpecialCcy = false;
        String stringFormattedDate =  dateInString.replace(" ", "-");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        LocalDate localDate = LocalDate.parse(stringFormattedDate, formatter);
        DayOfWeek dow = localDate.getDayOfWeek();

        //set default settlement date as requested settlement date
        calcFinalSettlmnt.setNewSettlementDate(localDate);
        calcFinalSettlmnt.setTradable(true);

        //Set flag for Currency = AED OR SAR and then Calculate final Settlement date based on currency
        if((currency.equals(AppConstants.CURRENCY_TYPE_AED.getId())||currency.equals(AppConstants.CURRENCY_TYPE_SER.getId()))){
            isSpecialCcy = true;
        }

        if(isSpecialCcy && (!dow.equals(FRIDAY) || !dow.equals(SATURDAY))){
            return calcFinalSettlmnt;
        }
        else if(!isSpecialCcy && !(dow.equals(SUNDAY) || dow.equals(SATURDAY))){
            return calcFinalSettlmnt;
        }
        else{
            LocalDate newSettlementDate = calculateFinalSettlmetDate(isSpecialCcy, localDate);
            calcFinalSettlmnt.setNewSettlementDate(newSettlementDate);
            calcFinalSettlmnt.setTradable(false);
        }


        return calcFinalSettlmnt;
    }

    //Logic for calculating the trading amount
    private void calculateTradeAmount(Trade trade){
        Double tradeAmount = (trade.getUnitPrice()*trade.getTradeUnits()*trade.getFxRate());
        trade.setTradeAmount(tradeAmount);
    }


    //Calculate the final settlement date based on Currency
    private LocalDate calculateFinalSettlmetDate(Boolean isSpecialCurrency, LocalDate date){
        LocalDate date1 = date;
        if(isSpecialCurrency){
            while(date1.getDayOfWeek()!=SUNDAY){
                date1=date1.plusDays(1);
            }
        }
        else {
            while (date1.getDayOfWeek()!=MONDAY){
                date1=date1.plusDays(1);
            }
        }
        return date1;
    }

    //Printing Report in the Console
    public StringBuilder generateFullTradeReport(List<Trade> trades, String src) {
        StringBuilder result = new StringBuilder();
        result.append("PRINTING "+src+ " TRADE REPORT");
        result.append("\n");
        result.append("===================================================================================================================================================");
        result.append("\n");
        result.append("ENTITY--|--BUY/SELL--|--AgreedFX--|--Currency--|--Instruction Date--|--Settlement Date--|--Final Settlement Date--|--Units--|--Price Per Unit--|--" +
                "Total Trade Price");
        result.append("\n");
        result.append("----------------------------------------------------------------------------------------------------------------------------------------------------");
        result.append("\n");
        for(Trade trade : trades) {
            result.append(trade.getEntityName() + "   --|--   " + trade.getTradedMethod() + "    --|--    " + String.format("%.2f",trade.getFxRate()) + " --|--  " + trade.getCurrency()
                    + "   --|--   " + trade.getInstructionDate()+ "  --|--      " + trade.getSettlementDate() + " --|-- "+trade.getFinalSettlDate()
                    +"    --|--  "+ trade.getTradeUnits() + " --|--  " + String.format("%.2f",trade.getUnitPrice())
                    + "     --|--  USD "+String.format("%.2f",trade.getTradeAmount()));
            result.append("\n");
        }
        return result;
    }


    public  List<Trade> getIncommingTrades() {
        return incommingTrades;
    }

    public  List<Trade> getOutgoingTrades() {
        return outgoingTrades;
    }
}
