package com.sparta.group2.model.sql;

import com.sparta.group2.model.EmployeeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements InterfaceDAO<EmployeeDTO> {

    private static final String selectAllEmployees = "SELECT * FROM employees";

    private static final String selectAnEmployee = "SELECT * FROM employees WHERE id=?";

    private static final String insertAnEmployee = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final Connection connection =ConnectionProvider.getConnection();


    @Override
<<<<<<< HEAD
    public void  insert(EmployeeDTO employeeDTO) {

        try (PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(insertAnEmployee)) {

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
=======
    public void insert(EmployeeDTO employeeDTO) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insertAnEmployee);
            preparedStatement.setInt(1, employeeDTO.getId());
            preparedStatement.setString(2, employeeDTO.getPrefix());
            preparedStatement.setString(3, employeeDTO.getFirstName());
            preparedStatement.setString(4, employeeDTO.getMiddleInitial());
            preparedStatement.setString(5, employeeDTO.getLastName());
            preparedStatement.setString(6, employeeDTO.getGender());
            preparedStatement.setString(7, employeeDTO.getMail());
            preparedStatement.setDate(8, Date.valueOf(employeeDTO.getDob())); //.toString() if not working
            preparedStatement.setDate(9, Date.valueOf(employeeDTO.getDob()));    //same
            preparedStatement.setDouble(10, employeeDTO.getSalary());
            preparedStatement.execute();
>>>>>>> dev


        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }

        return employees;
    }
}
