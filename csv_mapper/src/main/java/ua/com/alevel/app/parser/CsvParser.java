package ua.com.alevel.app.parser;

import java.util.List;

public interface CsvParser {

    void readData(String path);
    String get(int column, int row);
    String get(String key, int row);
    List<String> getHeaders();
    int size();
}
