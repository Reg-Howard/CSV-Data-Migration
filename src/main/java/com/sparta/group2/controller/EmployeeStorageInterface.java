package com.sparta.group2.controller;

import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.storage.EmployeeStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface EmployeeStorageInterface {
  //Controller for storage specific methods
  void addCleanItem(EmployeeDTO item);
  void addUncleanItem(EmployeeDTO item);

  HashMap<Integer, EmployeeDTO> getCleanList();
  HashMap<Integer, EmployeeDTO> getUncleanList();


}
