<%-- 
    Document   : AddEmployee
    Created on : Oct 6, 2025, 2:06:15 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h2>Add Employee</h2>
    <form action="AddEmployeeServlet" method="post">
        ID: <input type="number" name="id" required><br>
        Name: <input type="text" name="name" required><br>
        Salary: <input type="number" step="0.01" name="salary" required><br>
        <input type="submit" value="Add">
    </form>
</body>
</html>

