package com.sparta.group2.model.sql;

import com.sparta.group2.model.factory.FileDataReader;
import com.sparta.group2.model.storage.EmployeeStorage;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class ConnectionProvider {

    private static Connection connection = null;
    private static ConnectionProvider connectionProvider;
    private static Properties properties = new Properties();
    private ConnectionProvider(){

    }
    public static ConnectionProvider createrConnectionProvider() {
        if (connectionProvider == null) {
            connectionProvider = new ConnectionProvider();
            return connectionProvider;
        }
        return connectionProvider;
    }
    public static Connection getConnection(){
        if (connection == null) {
            try {
                properties.load(new FileReader("src/main/resources/login.properties"));
                getConnection(properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return connection;
    }
    public static Connection getConnection(String url, String username, String password){
        if (connection == null) {
            try {
                if(url==(null) || url.equals("")){
                    System.out.println("Please input url details");
                    return null;
                }
                if(username==(null) || username.equals("")){
                    System.out.println("Please input username details");
                    return null;
                }
                if(password==(null) || password.equals("")){
                    System.out.println("Please input password details");
                    return null;
                }
                connection = DriverManager.getConnection(url,username,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connection = null;
    }
}
