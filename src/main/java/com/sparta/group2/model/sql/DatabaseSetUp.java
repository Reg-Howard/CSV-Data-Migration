package com.sparta.group2.model.sql;

import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.model.storage.EmployeeStorageService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DatabaseSetUp {

 private static final String createDB = "CREATE DATABASE datamigration";

 private static final String createEmployeeTable = "CREATE TABLE employees (Id int NOT NULL PRIMARY KEY, Prefix varchar(10), FirstName varchar(255),MiddleInitial varchar(1), LastName varchar(255), Gender varchar(10), Email varchar(255), DoB date, StartDate date, salary double)";

 private static final String dropDB = "DROP DATABASE IF EXISTS datamigration";

  private static Properties properties = new Properties();
 public static void setUpDB() {

   try (PreparedStatement dropDbStatement = ConnectionProvider.getConnection().prepareStatement(
       dropDB); PreparedStatement createDbStatement = ConnectionProvider.getConnection()
       .prepareStatement(createDB)) {
     dropDbStatement.execute();
     createDbStatement.execute();

   } catch (SQLException e) {
     e.printStackTrace();
   }
 }

  public static void populateDB() {

    DAO dao = new DAO();
    try (PreparedStatement createTableStatement = ConnectionProvider.getConnection()
        .prepareStatement(createEmployeeTable)) {
      createTableStatement.execute();
      EmployeeStorageServiceInterface employeeServiceInterface = new EmployeeStorageService();
      employeeServiceInterface.getFromFactory();
      EmployeeStorage.getStorage().getCleanList()
          .forEach((integer, employeeDTO) -> dao.insert(employeeDTO));

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
