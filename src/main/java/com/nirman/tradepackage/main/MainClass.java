package com.nirman.tradepackage.main;


import com.nirman.tradepackage.model.Trade;
import com.nirman.tradepackage.service.impl.GenerateReportImpl;
import com.nirman.tradepackage.service.impl.LoadTrades;
import com.nirman.tradepackage.serviceI.GenerateReport;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class MainClass{



    public static void main(String[] args) throws IOException, ParseException {
        final String tradeFileName = "data.json";
        LoadTrades readTradeFile = new LoadTrades();

        List<Trade> trades = (List<Trade>) readTradeFile.loadFiles(tradeFileName);

        GenerateReport generateReport = new GenerateReportImpl();
        generateReport.generateReport(trades);

    }
}


