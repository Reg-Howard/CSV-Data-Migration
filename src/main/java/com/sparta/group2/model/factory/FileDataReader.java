
package com.sparta.group2.model.factory;


import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.model.storage.EmployeeStorageService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {

    public static void readFileLines(String fileName) {
        EmployeeStorageServiceInterface service = new EmployeeStorageService();
        String line;
        try (java.io.FileReader fr = new java.io.FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            while ((line = br.readLine()) != null) {
                if(line.contains("Emp ID")) continue;
                service.insertIntoList(EmployeeFactory.createEmployee(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

