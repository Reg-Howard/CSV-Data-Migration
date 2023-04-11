package com.sparta.group2.view;
import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.controller.EmployeeStorageStarter;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.model.storage.EmployeeStorageService;

import java.util.HashMap;
import java.util.Scanner;

public class CLI {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        long start1 = System.nanoTime();
        EmployeeStorageStarter.start();
        EmployeeStorageServiceInterface employeeServiceInterface = new EmployeeStorageService();
        employeeServiceInterface.getFromFactory();
        HashMap<Integer, EmployeeDTO> cleanList = EmployeeStorage.getStorage().getCleanList();
        HashMap<Integer, EmployeeDTO> uncleanList = EmployeeStorage.getStorage().getUncleanList();

        while (true) {
            System.out.println("Hello, Please select an option:");
            System.out.println("1. Display clean data");
            System.out.println("2. Display unclean data");
            System.out.println("3. Display the size of clean and unclean data");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("--------------CLEAN DATA--------------");
                    System.out.println();
                    System.out.println();
                    cleanList.forEach((integer, employeeDTO) -> System.out.println(employeeDTO.toString()));
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("--------------UNCLEAN DATA--------------");
                    System.out.println();
                    System.out.println();
                    uncleanList.forEach((id, employeeDTO) -> System.out.println(employeeDTO.toString()));
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Size of clean data: " + cleanList.size());
                    System.out.println("Size of unclean data: " + uncleanList.size());
                    break;
                case 4:
                    long end1 = System.nanoTime();
                    System.out.println("Elapsed Time in seconds: 0." + (end1 - start1));
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
