package com.acurian.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVParser {
    private CSVReader reader;
    private List<String[]> data;

    public List<String[]> getData(String csvFileName, boolean withHeader) throws IOException {
        setupParser(csvFileName, withHeader);
        data = new ArrayList<>();
        String[] line;
        while ((line = reader.readNext()) != null) {
            data.add(line);
        }
        reader.close();
        return data;
    }

    /**
     * Applicable only for csv files with 2 columns
     */
    public LinkedHashMap<String, String> getDataAsMap(String csvFileName, boolean withHeader) throws IOException {
        setupParser(csvFileName, withHeader);
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        String[] line;
        while ((line = reader.readNext()) != null) {
            data.put(line[0], line[1]);
        }
        reader.close();
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
