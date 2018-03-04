package com.nirman.tradepackage.model;


//      "Entity": "foo",
//              "TradeMetod": "B",
//              "AgreedFx": "0.50",
//              "Currency": "SGP",
//              "InstructionDate": "01 Jan 2016",
//              "SettlementDate": "02 Jan 2016",
//              "Units": "200",
//              "UnitPrice": "100.25"
public class Trade {
    private String entityName;
    private String tradedMethod;
    private double  fxRate;
    private String currency;
    private String instructionDate;
    private String  settlementDate;
    private String finalSettlDate;
    private long  tradeUnits;
    private double unitPrice;
    private double tradeAmount;



    public Trade() {
        super();
    }



    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setTradedMethod(String tradedMethod) {
        this.tradedMethod = tradedMethod;
    }

    public void setFxRate(double fxRate) {
        this.fxRate = fxRate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setInstructionDate(String instructionDate) {
        this.instructionDate = instructionDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public void setTradeUnits(long tradeUnits) {
        this.tradeUnits = tradeUnits;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getTradedMethod() {
        return tradedMethod;
    }

    public double getFxRate() {
        return fxRate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getInstructionDate() {
        return instructionDate;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public Long getTradeUnits() {
        return tradeUnits;
    }

    public double getUnitPrice() {
        return unitPrice;
    }


    public double getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(double tradeAmount) {
        this.tradeAmount = tradeAmount;
    }
    public String getFinalSettlDate() {
        return finalSettlDate;
    }

    public void setFinalSettlDate(String finalSettlDate) {
        this.finalSettlDate = finalSettlDate;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "entityName='" + entityName + '\'' +
                ", tradedMethod=" + tradedMethod +
                ", fxRate=" + fxRate +
                ", currency='" + currency + '\'' +
                ", instructionDate='" + instructionDate + '\'' +
                ", settlementDate='" + settlementDate + '\'' +
                ", tradeUnits=" + tradeUnits +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
