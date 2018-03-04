package com.nirman.tradepackage.service.impl;

import com.nirman.tradepackage.model.Trade;
import com.nirman.tradepackage.serviceI.ReadFiles;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoadTrades implements ReadFiles {


    @Override
    public Object loadFiles(String fileName) throws IOException, ParseException {

        //load trade file and store in Trade class
        JSONParser parser = new JSONParser();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        JSONObject object = (JSONObject) parser.parse(reader);
        JSONArray trades = (JSONArray) object.get("trades");

        List<Trade> tradeEntities = new ArrayList<>();
        for(int i=0; i<trades.size(); i++)
        {
            Trade trade = new Trade();
            JSONObject tradeObject= (JSONObject) trades.get(i);
            trade.setEntityName((String)tradeObject.get("Entity"));
            trade.setTradedMethod((String)tradeObject.get("TradeMetod"));
            trade.setFxRate((Double)tradeObject.get("AgreedFx"));
            trade.setCurrency((String)tradeObject.get("Currency"));
            trade.setInstructionDate((String)tradeObject.get("InstructionDate"));
            trade.setSettlementDate((String)tradeObject.get("SettlementDate"));
            trade.setTradeUnits((Long) tradeObject.get("Units"));
            trade.setUnitPrice((Double)tradeObject.get("UnitPrice"));

            tradeEntities.add(trade);

        }


        return tradeEntities;

    }
}
