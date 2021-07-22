package ua.com.alevel.app.data;

import ua.com.alevel.app.annotation.CsvField;

public class User {

    @CsvField(name = "user_name")
    public String userName;
    @CsvField(name = "login")
    public String login;
    @CsvField(name = "password")
    public String password;
    @CsvField(name = "age")
    public int age;

    @Override
    public String toString() {
        return "User{" +
                "userName = '" + userName + '\'' +
                ", login = '" + login + '\'' +
                ", password = '" + password + '\'' +
                ", age = " + age +
                '}';
    }
}
