package ua.com.alevel.app.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    public List<String[]> readData(String path) {
        try(CSVReader reader = new CSVReader(new FileReader(path))) {
            return reader.readAll();
        } catch (CsvException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
