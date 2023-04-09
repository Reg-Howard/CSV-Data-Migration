package com.sparta.group2;

import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.controller.EmployeeStorageStarter;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.model.storage.EmployeeStorageService;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        long start1 = System.nanoTime();
        EmployeeStorageStarter.start();
        EmployeeStorageServiceInterface employeeServiceInterface = new EmployeeStorageService();
        employeeServiceInterface.getFromFactory();
        HashMap<Integer, EmployeeDTO> cleanList = EmployeeStorage.getStorage().getCleanList();
        HashMap<Integer, EmployeeDTO> uncleanList = EmployeeStorage.getStorage().getUncleanList();

        System.out.println("--------------CLEAN DATA--------------");
        System.out.println();
        System.out.println();
        cleanList.forEach((integer, employeeDTO) -> System.out.println(employeeDTO.toString()));
        System.out.println();
        System.out.println();

        System.out.println("--------------UNCLEAN DATA--------------");
        System.out.println();
        System.out.println();

        uncleanList.forEach((id, employeeDTO) -> System.out.println(employeeDTO.toString()));

        System.out.println();
        System.out.println();

        System.out.println("Size of clean data: " + cleanList.size());
        System.out.println("Size of unclean data: " + uncleanList.size());
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in seconds: 0."+ (end1-start1) );


    }
}
