package com.acurian.selenium.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    private CSVReader reader;
    private List<String[]> data;

    public List<String[]> getData(String csvFileName, boolean withHeader) {
        setupParser(csvFileName, withHeader);
        data = new ArrayList<>();
        String[] line;
        try {
            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getColumns() {
        return data.get(0).length;
    }

    public int getRows() {
        return data.size();
    }

    private void setupParser(String csvFileName, boolean withHeader) {
        try {
            if (withHeader) {
                reader = new CSVReaderBuilder(new FileReader(new File(System.getProperty("resources.dir") + csvFileName)))
                        .withSkipLines(1)
                        .build();
            } else {
                reader = new CSVReaderBuilder(new FileReader(new File(System.getProperty("resources.dir") + csvFileName)))
                        .build();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
