package com.example.baithilai.model;

import com.example.baithilai.constant.SqlConstant;
import com.example.baithilai.entity.Employee;
import com.example.baithilai.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlEmployeeModel implements EmployeeModel{

    @Override
    public boolean save(Employee obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SqlConstant.EMPLOYEE_INSERT);
            preparedStatement.setString(1, obj.getFullName());
            preparedStatement.setString(2, obj.getBirthday().toString());
            preparedStatement.setString(3, obj.getAddress());
            preparedStatement.setString(4, obj.getPosition());
            preparedStatement.setString(5, obj.getDepartment());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.EMPLOYEE_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee obj = convertResultSetToPhone(resultSet);
                if (obj != null) {
                    listObj.add(obj);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listObj;
    }

    private Employee convertResultSetToPhone(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(SqlConstant.EMPLOYEE_FIELD_ID);
            String fullName = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_FULLNAME);
            String birthday = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_BIRTHDAY);
            String address = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_ADDRESS);
            String position = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_POSITION);
            String department = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_DEPARTMENT);
            return Employee.EmployeeBuilder.anEmployee()
                    .withId(id)
                    .withFullName(fullName)
                    .withBirthday(birthday)
                    .withAddress(address)
                    .withPosition(position)
                    .withDepartment(department)
                    .build();
        } catch (SQLException ex) {
            return null;
        }
    }
}
