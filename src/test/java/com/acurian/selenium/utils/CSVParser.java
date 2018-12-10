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

    public List<String[]> getData(String csvFileName) {
        setupParser(csvFileName);
        List<String[]> data = new ArrayList<>();
        try {
            data = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void setupParser(String csvFileName) {
        try {
            reader = new CSVReaderBuilder(new FileReader(new File(System.getProperty("resources.dir") + csvFileName)))
                    .withSkipLines(1)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
