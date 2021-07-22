package ua.com.alevel.app.table;

import java.util.List;

public interface CsvTable {

    List<String> getHeaders();

    String get(int row, String title);

    String get(int row, int col);

    List<String[]> getValues();
}
