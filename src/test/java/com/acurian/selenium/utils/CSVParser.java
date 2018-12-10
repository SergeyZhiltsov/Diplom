package com.acurian.selenium.utils;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class CSVParser {
    private CSVReader reader;

    public CSVParser(String csvFileName) {
        File file = new File(csvFileName);
        try {
            reader = new CSVReader(new FileReader(file.getAbsolutePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LinkedHashMap<String, String> getDataFrom2Rows() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        String[] line;
        try {
            while ((line = reader.readNext()) != null) {
                data.put(line[0], line[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
