<%-- 
    Document   : UpdateEmployeeResult
    Created on : Oct 6, 2025, 2:07:14 PM
    Author     : User
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Employee" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee Result</title>
    <style>
        table { border-collapse: collapse; width: 60%; margin-top: 20px; }
        th, td { border: 1px solid #888; padding: 8px; text-align: center; }
        th { background-color: #eee; }
    </style>
</head>
<body>
    <h2>Update Employee Result</h2>
    <p>${message}</p>

    <h3>Current Employee List</h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Version</th>
        </tr>
        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            if (employees != null && !employees.isEmpty()) {
                for (Employee emp : employees) {
        %>
        <tr>
            <td><%= emp.getEmployeeid() %></td>
            <td><%= emp.getEmployeename() %></td>
            <td><%= emp.getSalary() %></td>
            <td><%= emp.getVersion() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="4">No employees found.</td></tr>
        <%
            }
        %>
    </table>

    <br>
    <a href="Menu.jsp">Back to Menu</a>
</body>
</html>


