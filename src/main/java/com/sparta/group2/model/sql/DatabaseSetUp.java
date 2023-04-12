package com.sparta.group2.model.sql;

import com.sparta.group2.Main;
import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.model.storage.EmployeeStorageService;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DatabaseSetUp { private static final Logger LOGGER = LogManager.getLogger(Main.class);
 private static final String createDB = "CREATE DATABASE datamigration";

 private static final String createEmployeeTable = "CREATE TABLE employees (Id int NOT NULL PRIMARY KEY, Prefix varchar(10), FirstName varchar(255),MiddleInitial varchar(1), LastName varchar(255), Gender varchar(10), Email varchar(255), DoB date, StartDate date, salary double)";

 private static final String useDB ="USE dataMigration";

 private static final String dropDB = "DROP DATABASE IF EXISTS dataMigration";

 private static final Connection connection =ConnectionProvider.getConnection();


 public static void setUpAndPopulateDB(){

     DAO dao= new DAO();

     try {
          PreparedStatement dbStatement = connection.prepareStatement(dropDB);
          dbStatement.execute();
          dbStatement = connection.prepareStatement(createDB);
          dbStatement.execute();
          dbStatement = connection.prepareStatement(useDB);
          dbStatement.execute();
          dbStatement = connection.prepareStatement(createEmployeeTable);
          dbStatement.execute();

//         PreparedStatement dropDbStatement = connection.prepareStatement(dropDB);
//         dropDbStatement.execute();
//         PreparedStatement createDbStatement = connection.prepareStatement(createDB);
//         createDbStatement.execute();
//         PreparedStatement useDBStatement = connection.prepareStatement(useDB);
//         useDBStatement.execute();
//         PreparedStatement createTableStatement = connection.prepareStatement(createEmployeeTable);
//         createTableStatement.execute();
         //EmployeeStorage.getStorage().getCleanList().forEach((idKey, employeeDTO) -> dao.insert(employeeDTO));

       List<EmployeeDTO> employeeDTOList = new ArrayList<>(EmployeeStorage.getStorage().getCleanList().values());
       dao.batchInsert(employeeDTOList);
     } catch (SQLException e) {
       LOGGER.error(e.getMessage(), e);
     }
 }

}
