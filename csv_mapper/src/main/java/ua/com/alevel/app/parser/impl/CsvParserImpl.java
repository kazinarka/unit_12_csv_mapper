package ua.com.alevel.app.parser.impl;

import ua.com.alevel.app.parser.CsvParser;

import java.util.List;

public class CsvParserImpl implements CsvParser {

    private final List<String[]> data;

    public CsvParserImpl(List<String[]> data) {
        this.data = data;
    }

    public String[] getHeaders() {
        return data.get(0);
    }

    public List<String[]> getValues() {
        return data.subList(1, data.size());
    }
}
