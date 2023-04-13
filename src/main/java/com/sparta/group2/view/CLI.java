package com.sparta.group2.view;

import com.sparta.group2.Main;
import com.sparta.group2.controller.EmployeeStorageInterface;
import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.controller.EmployeeStorageStarter;
import com.sparta.group2.controller.InterfaceDAO;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.sql.DAO;
import com.sparta.group2.model.sql.DatabaseSetUp;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.model.storage.EmployeeStorageService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CLI {
  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  public void run() {

    EmployeeStorageStarter.start();
    EmployeeStorageServiceInterface employeeServiceInterface = new EmployeeStorageService();
    EmployeeStorageInterface storageInterface = EmployeeStorage.getStorage();

    System.out.println("Please wait whilst data is fetched and stored.");
    long start1 = System.nanoTime();
    try {
      employeeServiceInterface.getFromFactory();
      DatabaseSetUp.setUpAndPopulateDB();
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      System.out.println("Start up failed, exiting");
      System.exit(0);
    }
    long end1 = System.nanoTime();
    System.out.println("Time taken to setup: " + (end1 - start1) / 1000000000 + "seconds \n");

    InterfaceDAO dao = new DAO();
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, EmployeeDTO> cleanList = storageInterface.getCleanList();
    HashMap<Integer, EmployeeDTO> uncleanList = storageInterface.getUncleanList();

    while (true) {
        System.out.println("Hello, Please select an option:");
        System.out.println("1. Display clean data");
        System.out.println("2. Display unclean data");
        System.out.println("3. Display employees with duplicate ID's");
        System.out.println("4. Display negative salary employees");
        System.out.println("5. Display employees with \"FALSE\" middle name");
        System.out.println("6. Display the size of clean and unclean data");
        System.out.println("7. Display all records stored in the database");
        System.out.println("8. To display a specific employee by ID");
        System.out.println("9. Exit");
        String input = scanner.nextLine();
        try {
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    System.out.println("--------------CLEAN DATA--------------");
                    System.out.println();
                    System.out.println();
                    cleanList.forEach(
                        (integer, employeeDTO) -> System.out.println(employeeDTO.toString()));
                    System.out.println("Amount of items that are clean: " + cleanList.size());
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("--------------UNCLEAN DATA--------------");
                    System.out.println();
                    System.out.println();
                    uncleanList.forEach(
                        (id, employeeDTO) -> System.out.println(employeeDTO.toString()));
                    System.out.println("Amount of items that are un-clean: " + uncleanList.size());
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Employees with a duplicate ID:");
                    System.out.println("Amount: " + employeeServiceInterface.listOfDuplicateIDs());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Employees with a negative salary:");
                    System.out.println(
                        "Amount: " + employeeServiceInterface.employeesWithNegativeSalary());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Employees with incorrect middle name field");
                    System.out.println(
                        "Amount: " + employeeServiceInterface.employeesWithBadMiddleName());
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Size of clean data: " + cleanList.size() + "\n");
                    System.out.println("Size of unclean data: " + uncleanList.size() + "\n");
                    break;
                case 7:
                    List<EmployeeDTO> dto = dao.findAll();
                    dto.forEach(System.out::println);
                    System.out.println("SUCCESSFULLY PRINTED ALL EMPLOYEE RECORDS!\n");

                    break;
                case 8:
                    System.out.println("Please enter an Employee ID:");
                    String nextLine = scanner.nextLine();
                    try {
                        int employeeID = Integer.parseInt(nextLine);
                        if (dao.findById(employeeID) != null) {
                            System.out.println(dao.findById(employeeID));
                            System.out.println("SUCCESSFULLY PRINTED EMPLOYEE RECORD!\n");
                            System.out.println();
                        } else {
                            System.out.println("Invalid ID");
                            System.out.println();
                        }
                    } catch (NumberFormatException e){
                        LOGGER.error(e.getMessage(), e);

                        System.out.println("\nNot an ID please try again\n");
                    }
                    break;
                case 9:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.\n");
                    break;

            }
        } catch (NumberFormatException e) {
            LOGGER.error(e.getMessage(), e);
            System.out.println("\nIncorrect input please try again\n");
        }
    }
  }
}
