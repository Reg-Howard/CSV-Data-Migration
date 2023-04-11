package com.sparta.group2.model.sql;

import com.sparta.group2.model.storage.EmployeeStorage;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseSetUp {

 private static final String createDB = "CREATE DATABASE dataMigration";

 private static final String createEmployeeTable = "CREATE TABLE employees (Id int NOT NULL PRIMARY KEY, Prefix varchar(10), FirstName varchar(255),MiddleInitial varchar(1), LastName varchar(255), Gender varchar(10), Email varchar(255), DoB date, StartDate date, salary double)";

 private static final String dropDB = "DROP DATABASE IF EXIST dataMigration";


 private static void setUpAndPopulateDB(){

     DAO dao= new DAO();

     try {
         PreparedStatement dropDbStatement = ConnectionProvider.getConnection().prepareStatement(dropDB);
         dropDbStatement.execute();
         PreparedStatement createDbStatement = ConnectionProvider.getConnection().prepareStatement(createDB);
         createDbStatement.execute();
         PreparedStatement createTableStatement = ConnectionProvider.getConnection().prepareStatement(createEmployeeTable);
         createTableStatement.execute();
         EmployeeStorage.getStorage().getCleanList().forEach((integer, employeeDTO) -> dao.insert(employeeDTO));

     } catch (SQLException e) {
         throw new RuntimeException(e);
     }

 }
}
