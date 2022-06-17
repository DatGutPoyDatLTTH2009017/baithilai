package com.example.baithilai.controller;

import com.example.baithilai.entity.Employee;
import com.example.baithilai.model.EmployeeModel;
import com.example.baithilai.model.MySqlEmployeeModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmployeeServlet extends HttpServlet {
    private EmployeeModel employeeModel;
    public AddEmployeeServlet(){
        this.employeeModel = new MySqlEmployeeModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addemployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            String fullName = req.getParameter("fullName");
            String birthday = req.getParameter("birthday");
            String address = req.getParameter("address");
            String position = req.getParameter("position");
            String department = req.getParameter("department");
            Employee employee = Employee.EmployeeBuilder.anEmployee()
                    .withFullName(fullName)
                    .withBirthday(birthday)
                    .withAddress(address)
                    .withPosition(position)
                    .withDepartment(department)
                    .build();
            if (employee.isValid()){
                boolean result = employeeModel.save(employee);
                if (result){
                    resp.sendRedirect("/listemployee");
                }else {
                    try {
                        throw new Exception("Cant save employee");
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }else {
                req.setAttribute("employee", employee);
                req.setAttribute("errors", employee.getErrors());
                req.getRequestDispatcher("/addemployee.jsp").forward(req, resp);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
