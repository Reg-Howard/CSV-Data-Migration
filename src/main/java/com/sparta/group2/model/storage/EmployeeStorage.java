package com.sparta.group2.model.storage;

import com.sparta.group2.controller.EmployeeStorageInterface;
import com.sparta.group2.model.EmployeeDTO;

import java.util.HashMap;

public class EmployeeStorage implements EmployeeStorageInterface {
  private static EmployeeStorage employeeStorage;
  private static HashMap<Integer, EmployeeDTO> cleanList;
  private static HashMap<Integer, EmployeeDTO> uncleanList;
  private EmployeeStorage(){

  }
  //Singleton pattern
  public static EmployeeStorage createEmployeeStorage() {
    if (employeeStorage == null) {
      employeeStorage = new EmployeeStorage();
      cleanList = new HashMap<>(100000);
      uncleanList = new HashMap<>(100000);
      return employeeStorage;
    }
    return employeeStorage;
  }

  public static EmployeeStorage getStorage() {
    return employeeStorage;
  }
  @Override
  public HashMap<Integer, EmployeeDTO> getCleanList() {
    return cleanList;
  }

  @Override
  public HashMap<Integer, EmployeeDTO> getUncleanList() {
    return uncleanList;
  }
  @Override
  public void addCleanItem(EmployeeDTO item){
    cleanList.put(item.hashCode(), item);
  }
  @Override
  public void addUncleanItem(EmployeeDTO item){
    uncleanList.put(item.hashCode(), item);
  }
}