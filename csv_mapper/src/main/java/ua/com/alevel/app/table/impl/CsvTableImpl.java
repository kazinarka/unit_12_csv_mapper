package ua.com.alevel.app.table.impl;

import ua.com.alevel.app.parser.CsvParser;
import ua.com.alevel.app.table.CsvTable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTableImpl implements CsvTable {

    private final String[] headers;
    private final List<String[]> values;

    public CsvTableImpl(CsvParser csvParser) {
        headers = csvParser.getHeaders();
        values = csvParser.getValues();
    }

    public List<String> getHeaders() {
        return Arrays.stream(headers).collect(Collectors.toList());
    }

    public String get(int row, String title) {
        for (int col = 0; col < headers.length; col++) {
            if(headers[col].equals(title))
                return get(row, col);
        }
        throw new IllegalArgumentException("Title = '" + title + '\'' + " doesn't exist");
    }

    public String get(int row, int col) {
        return values.get(row)[col];
    }

    public List<String[]> getValues() {
        return values;
    }
}
