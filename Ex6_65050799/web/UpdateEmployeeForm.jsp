<%-- 
    Document   : UpdateEmployeeForm
    Created on : Oct 6, 2025, 2:07:02 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="emp" type="Model.Employee" scope="request"/>
<!DOCTYPE html>
<html>
<head><title>Update Employee</title></head>
<body>
    <h2>Update Employee Info</h2>
    <form action="UpdateEmployeeServlet" method="post">
        ID: <input type="text" name="id" value="${emp.employeeid}" readonly><br>
        Name: <input type="text" name="name" value="${emp.employeename}"><br>
        Salary: <input type="number" step="0.01" name="salary" value="${emp.salary}"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>

