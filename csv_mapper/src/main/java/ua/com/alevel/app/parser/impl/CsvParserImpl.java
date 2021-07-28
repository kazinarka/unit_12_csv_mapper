package ua.com.alevel.app.parser.impl;

import ua.com.alevel.app.parser.CsvParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class CsvParserImpl implements CsvParser {

    private final LinkedHashMap<String, ArrayList<String>> csvTable;
    private int size = 0;

    public CsvParserImpl() {
        csvTable = new LinkedHashMap<>();
    }

    public String get(int column, int row) {
        List<List<String>> table = new ArrayList<>(csvTable.values());
        return table.get(column).get(row);
    }

    public String get(String key, int row) {
        return csvTable.get(key).get(row);
    }

    public List<String> getHeaders() {
        return new ArrayList<>(csvTable.keySet());
    }

    public int size() {
        return size;
    }

    public void readData(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = "";
            line = reader.readLine();
            List<String> header = Arrays.asList(line.split(","));
            while ((line = reader.readLine()) != null) {
                List<String> row = Arrays.asList(line.split(","));
                fillTable(header, row);
                size++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillTable(List<String> keys, List<String> values) {
        for (int i = 0; i < keys.size(); i++) {
            if (!(csvTable.containsKey(keys.get(i)))) {
                ArrayList<String> valueList = new ArrayList<>();
                valueList.add(values.get(i));
                csvTable.put(keys.get(i), valueList);
            } else {
                csvTable.get(keys.get(i)).add(values.get(i));
            }
        }
    }
}
