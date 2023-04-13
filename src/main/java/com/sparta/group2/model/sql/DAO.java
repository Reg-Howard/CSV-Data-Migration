package com.sparta.group2.model.sql;

import com.sparta.group2.Main;
import com.sparta.group2.controller.InterfaceDAO;
import com.sparta.group2.model.EmployeeDTO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements InterfaceDAO<EmployeeDTO> {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String selectAllEmployees = "SELECT * FROM employees";

    private static final String selectAnEmployee = "SELECT * FROM employees WHERE id=?";

    private static final String insertAnEmployee = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final Connection connection =ConnectionProvider.getConnection();

    public void batchInsert(List<EmployeeDTO> employeeDTO){
        try(PreparedStatement preparedStatement = connection.prepareStatement(insertAnEmployee)){
//            employeeDTO.forEach(emp -> {
//                try {
//                    preparedStatement.setInt(1,emp.getId());
//                    preparedStatement.setString(2,emp.getPrefix());
//                    preparedStatement.setString(3,emp.getFirstName());
//                    preparedStatement.setString(4,emp.getMiddleInitial());
//                    preparedStatement.setString(5,emp.getLastName());
//                    preparedStatement.setString(6,emp.getGender());
//                    preparedStatement.setString(7,emp.getMail());
//                    preparedStatement.setDate(8, Date.valueOf(emp.getDob())); //.toString() if not working
//                    preparedStatement.setDate(9,Date.valueOf(emp.getStartDate()));    //same
//                    preparedStatement.setDouble(10,emp.getSalary());
//                    preparedStatement.addBatch();
//                } catch (SQLException e) {
//                    LOGGER.error(e.getMessage(), e);
//                }
//            } );
//            preparedStatement.executeBatch();

            for(EmployeeDTO emp: employeeDTO){
                preparedStatement.setInt(1,emp.getId());
                preparedStatement.setString(2,emp.getPrefix());
                preparedStatement.setString(3,emp.getFirstName());
                preparedStatement.setString(4,emp.getMiddleInitial());
                preparedStatement.setString(5,emp.getLastName());
                preparedStatement.setString(6,emp.getGender());
                preparedStatement.setString(7,emp.getMail());

                preparedStatement.setDate(8, Date.valueOf(emp.getDob())); //.toString() if not working
                preparedStatement.setDate(9,Date.valueOf(emp.getStartDate()));    //same

                preparedStatement.setDouble(10,emp.getSalary());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


    public void  insert(EmployeeDTO employeeDTO) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAnEmployee)) {

        preparedStatement.setInt(1,employeeDTO.getId());
        preparedStatement.setString(2,employeeDTO.getPrefix());
        preparedStatement.setString(3,employeeDTO.getFirstName());
        preparedStatement.setString(4,employeeDTO.getMiddleInitial());
        preparedStatement.setString(5,employeeDTO.getLastName());
        preparedStatement.setString(6,employeeDTO.getGender());
        preparedStatement.setString(7,employeeDTO.getMail());
        preparedStatement.setDate(8, Date.valueOf(employeeDTO.getDob())); //.toString() if not working
        preparedStatement.setDate(9,Date.valueOf(employeeDTO.getDob()));    //same
        preparedStatement.setDouble(10,employeeDTO.getSalary());
        preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public EmployeeDTO findById(int id) {
        EmployeeDTO employeeDTO = null;
        try(PreparedStatement preparedStatement =connection.prepareStatement(selectAnEmployee)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                employeeDTO = new EmployeeDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getDate(8).toLocalDate(),
                        resultSet.getDate(9).toLocalDate(),
                        resultSet.getDouble(10));
            } else {
                System.out.println("No records in the table.");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<EmployeeDTO> employees = new ArrayList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectAllEmployees)) {
            ResultSet resultSet = preparedStatement.executeQuery(selectAllEmployees);
            if (resultSet != null) {
                while (resultSet.next()) {
                    EmployeeDTO employee = new EmployeeDTO(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getDate(8).toLocalDate(),
                            resultSet.getDate(9).toLocalDate(),
                            resultSet.getDouble(10));

                    employees.add(employee);
                }
            } else {
                System.out.println("No records in the table.");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return employees;
    }
}
