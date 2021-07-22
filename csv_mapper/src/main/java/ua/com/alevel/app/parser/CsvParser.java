package ua.com.alevel.app.parser;

import java.util.List;

public interface CsvParser {

    String[] getHeaders();

    List<String[]> getValues();
}
