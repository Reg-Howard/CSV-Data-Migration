package com.sparta.group2.model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.sparta.group2.controller.EmployeeStorageInterface;
import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.controller.EmployeeStorageStarter;
import com.sparta.group2.model.factory.EmployeeFactory;

import com.sparta.group2.model.storage.EmployeeStorageService;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeStorageChecks {
  static EmployeeDTO emp1, emp2;
  static EmployeeStorageInterface employeeStorageInterface;

  @BeforeAll
  static void setup() {

    employeeStorageInterface = EmployeeStorage.createEmployeeStorage();
    emp1 =
            EmployeeFactory.createEmployee(
                    "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
    emp2 =
            EmployeeFactory.createEmployee(
                    "111111,Mrs.,Serafina,FALSE,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");

    employeeStorageInterface.addUncleanItem(emp2);

    employeeStorageInterface.addCleanItem(emp1);
  }

  @Nested
  @DisplayName("Employee storage validation checks:")
  public class EmployeeStorageValidationChecks {
    @Test
    @Order(1)
    void testEmployeeStorageMethods() {
      EmployeeDTO mockDTO = mock(EmployeeDTO.class);
      EmployeeStorage mockes = mock(EmployeeStorage.class);
      EmployeeStorageServiceInterface mockESSI = mock(EmployeeStorageServiceInterface.class);

      mockes.getCleanList();
      mockes.getUncleanList();
      mockes.addCleanItem(mockDTO);
      mockes.addUncleanItem(mockDTO);
      verify(mockes).getCleanList();
      verify(mockes).getUncleanList();
      verify(mockes).addCleanItem(mockDTO);
      verify(mockes).addUncleanItem(mockDTO);

      mockESSI.getFromFactory();
      mockESSI.insertIntoList(mockDTO);

      verify(mockESSI).getFromFactory();
      verify(mockESSI).insertIntoList(mockDTO);
    }
    @Test
    @Order(2)
    void testEmployeeStorageExistsOnlyOnce() {
      EmployeeStorageInterface employeeStorageInterface2 = EmployeeStorage.createEmployeeStorage();
      EmployeeStorage employeeStorage2 = EmployeeStorage.createEmployeeStorage();
      Assertions.assertEquals(employeeStorageInterface, employeeStorageInterface2);
      Assertions.assertEquals(EmployeeStorage.getStorage(), employeeStorage2);
    }
    @Test
    @Order(3)
    void testEmployeeStorageAddToCleanList() {
      Assertions.assertEquals(emp1.hashCode(), employeeStorageInterface.getCleanList().get(emp1.getId()).hashCode());
    }
    @Test
    @Order(4)
    void testEmployeeStorageAddToUncleanList() {

      Assertions.assertEquals(emp2.hashCode(), employeeStorageInterface.getUncleanList().get(emp2.getId()).hashCode());
    }
    @Test
    @Order(5)
    void testEmployeeStorageInsertionByMapSize() {
      Assertions.assertEquals(1, employeeStorageInterface.getCleanList().size());
      Assertions.assertEquals(1, employeeStorageInterface.getUncleanList().size());
    }
    @Test
    @Order(6)
    void testStorageServiceGettingDataFromFactory() {
      EmployeeStorageServiceInterface employeeStorageServiceInterface = new EmployeeStorageService();
      employeeStorageServiceInterface.getFromFactory();
      int totalEntries = 10002;
      Assertions.assertEquals(totalEntries, employeeStorageInterface.getCleanList().size() + employeeStorageInterface.getUncleanList().size());
    }
    @Test
    @Order(7)
    void testEmployeeStorageCleanList() {
      EmployeeDTO emp3 = EmployeeFactory.createEmployee(
              "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
      Assertions.assertEquals(emp3.toString(), employeeStorageInterface.getCleanList().get(emp1.getId()).toString());

    }
    @Test
    @Order(8)
    void testEmployeeStorageUncleanList() {
      EmployeeDTO emp4 = EmployeeFactory.createEmployee(
              "111111,Mrs.,Serafina,FALSE,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
      Assertions.assertEquals(emp4.toString(), employeeStorageInterface.getUncleanList().get(emp2.getId()).toString());
    }
    @Test
    @Order(9)
    void testEmployeeStorageStarter() {
      Assertions.assertSame(EmployeeStorageStarter.start(), EmployeeStorage.createEmployeeStorage());
    }
    @Test
    @Order(10)
    void testEmployeeStorageInsertionByObjectEquality() {
      EmployeeDTO emp5 = EmployeeFactory.createEmployee(
              "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
      Assertions.assertTrue(
              emp5.equals(employeeStorageInterface.getCleanList().get(emp1.getId())));

    }
    @Test
    @Order(11)
    void testStorageServiceInsertingIntoList() {
      EmployeeStorageServiceInterface employeeStorageServiceInterface = new EmployeeStorageService();
      EmployeeDTO emp6 = EmployeeFactory.createEmployee(
              "198429,Mrs.,Serafina,FALSE,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
      EmployeeDTO emp7 = EmployeeFactory.createEmployee(
              "32133,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
      employeeStorageServiceInterface.insertIntoList(emp6);
      employeeStorageServiceInterface.insertIntoList(emp7);

      Assertions.assertEquals(emp6.getId(), employeeStorageInterface.getUncleanList().get(emp6.getId()).getId());
      Assertions.assertEquals(emp7.getId(), employeeStorageInterface.getCleanList().get(emp7.getId()).getId());
    }
  }
}
