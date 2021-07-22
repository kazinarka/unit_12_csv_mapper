package ua.com.alevel.app;

import ua.com.alevel.app.data.User;
import ua.com.alevel.app.parser.CsvParser;
import ua.com.alevel.app.parser.impl.CsvParserImpl;
import ua.com.alevel.app.table.CsvTable;
import ua.com.alevel.app.table.impl.CsvTableImpl;
import ua.com.alevel.app.util.FileUtils;
import ua.com.alevel.app.util.InitUtils;

import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        CsvParser csvParser = new CsvParserImpl(fileUtils.readData("csv_mapper/csv/user.csv"));
        CsvTable csvTable = new CsvTableImpl(csvParser);
        InitUtils initUtils = new InitUtils();
        List<User> usersInfo = initUtils.initialize(User.class, csvTable);

        //Demo
        System.out.println(usersInfo);
        System.out.println(csvTable.getHeaders());
        System.out.println(csvTable.get(0,0));
        System.out.println(csvTable.get(1,"user_name"));
    }
}
