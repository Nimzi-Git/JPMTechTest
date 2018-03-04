package com.nirman.tradepackage.serviceI;

import com.nirman.tradepackage.model.Trade;

import java.util.List;

public interface GenerateReport {
    public void generateReport(List<Trade> trades);
}
