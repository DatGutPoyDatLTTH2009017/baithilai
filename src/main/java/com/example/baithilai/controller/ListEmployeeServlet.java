package com.example.baithilai.controller;

import com.example.baithilai.entity.Employee;
import com.example.baithilai.model.EmployeeModel;
import com.example.baithilai.model.MySqlEmployeeModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListEmployeeServlet extends HttpServlet {

    private EmployeeModel employeeModel;

    public ListEmployeeServlet() {
        this.employeeModel = new MySqlEmployeeModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employees", employeeModel.findAll());
        request.getRequestDispatcher("/listemployee.jsp").forward(request, response);
    }
}
