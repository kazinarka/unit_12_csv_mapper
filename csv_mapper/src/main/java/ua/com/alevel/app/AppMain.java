package ua.com.alevel.app;

import ua.com.alevel.app.data.User;
import ua.com.alevel.app.mapper.CsvMapper;
import ua.com.alevel.app.parser.CsvParser;
import ua.com.alevel.app.parser.impl.CsvParserImpl;

import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        CsvParser csvParser = new CsvParserImpl();
        csvParser.readData("csv_mapper/csv/user.csv");
        List<User> userInfo;
        CsvMapper csvMapper = new CsvMapper();
        userInfo = csvMapper.initialize(User.class, csvParser);

        //Demo
        System.out.println(userInfo);
        System.out.println(csvParser.getHeaders());
        System.out.println(csvParser.get(0,0));
        System.out.println(csvParser.get("login", 0));
    }
}
