<%@ page import="com.example.baithilai.entity.Employee" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: uinhi
  Date: 6/17/2022
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Employee employee = (Employee) request.getAttribute("employee");
    if (employee == null) {
        employee = new Employee();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
%>
<%System.out.println(errors);%>
<!DOCTYPE html>
<html>
<title>Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
    .button {
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        transition-duration: 0.4s;
        cursor: pointer;
    }
    .button1 {
        background-color: white;
        color: black;
        border: 2px solid #4CAF50;
    }
    .button1:hover {
        background-color: #4CAF50;
        color: white;
    }
    .button2 {
        background-color: white;
        color: black;
        border: 2px solid #008CBA;
    }
    .button2:hover {
        background-color: #008CBA;
        color: white;
    }
    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .valid {
        color: red;
        font-size: 13px;
    }
</style>
<body>

<div class="w3-container">

    <div class="w3-card-4">
        <div class="w3-container w3-green">
            <h2>Input Employee</h2>
        </div>

        <form action="/addemployee" method="post" class="w3-container">
            <p>
                <label>FullName</label>
                <input class="w3-input" name="name" type="text" value="<%=employee.getFullName()%>"/>
                    <%
            if (errors.containsKey("fullName")) {
        %>
            <p class="valid">* <%=errors.get("fullName")%>
            </p>
            <%}%>
            </p>
            <p>
                <label>Birthday</label>
                <input class="w3-input" name="birthday" type="number" value="<%=employee.getBirthday()%>">
                    <%
            if (errors.containsKey("birthday")) {
        %>
            <p class="valid">* <%=errors.get("birthday")%>
            </p>
            <%}%>
            </p>
            <p>
                <label>Address</label>
                <input class="w3-input" name="address" type="text" value="<%=employee.getAddress()%>">
                    <%
                if (errors.containsKey("address")) {
            %>
            <p class="valid">* <%=errors.get("address")%>
            </p>
            <%}%>
            </p>
            <p>
                <label>Position</label>
                <input class="w3-input" name="position" type="text" value="<%=employee.getPosition()%>">
                    <%
                if (errors.containsKey("position")) {
            %>
            <p class="valid">* <%=errors.get("position")%>
            </p>
            <%}%>
            </p>
            <p>
                <label>Department</label>
                <input class="w3-input" name="department" type="text" value="<%=employee.getDepartment()%>">
                    <%
                if (errors.containsKey("department")) {
            %>
            <p class="valid">* <%=errors.get("department")%>
            </p>
            <%}%>
            </p>
            <button type="submit" class="button button1">Save</button>
            <button type="reset" class="button button2">Reset</button>
        </form>
    </div>
</div>
</body>
</html>