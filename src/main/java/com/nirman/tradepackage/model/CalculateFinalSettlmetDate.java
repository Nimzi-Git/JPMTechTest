package com.nirman.tradepackage.model;

import java.time.LocalDate;

public class CalculateFinalSettlmetDate {
    private Boolean isTradable;
    private LocalDate newSettlementDate;

    public CalculateFinalSettlmetDate() {
    }

    public CalculateFinalSettlmetDate(Boolean isTradable, LocalDate newSettlementDate) {
        this.isTradable = isTradable;
        this.newSettlementDate = newSettlementDate;
    }

    public Boolean getTradable() {
        return isTradable;
    }

    public void setTradable(Boolean tradable) {
        isTradable = tradable;
    }

    public LocalDate getNewSettlementDate() {
        return newSettlementDate;
    }

    public void setNewSettlementDate(LocalDate newSettlementDate) {
        this.newSettlementDate = newSettlementDate;
    }
}
