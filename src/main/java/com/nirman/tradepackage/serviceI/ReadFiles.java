package com.nirman.tradepackage.serviceI;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface ReadFiles {
    Object loadFiles(String fileName) throws IOException, ParseException;
}
