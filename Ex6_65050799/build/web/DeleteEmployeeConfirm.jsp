<%-- 
    Document   : DeleteEmployeeConfirm
    Created on : Oct 6, 2025, 2:13:55 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="emp" type="Model.Employee" scope="request"/>
<!DOCTYPE html>
<html>
<head><title>Confirm Delete</title></head>
<body>
    <h3>Are you sure you want to delete this employee?</h3>
    <p>ID: ${emp.employeeid}</p>
    <p>Name: ${emp.employeename}</p>
    <p>Salary: ${emp.salary}</p>

    <form action="DeleteEmployeeServlet" method="post">
        <input type="hidden" name="id" value="${emp.employeeid}">
        <input type="submit" value="Submit">
    </form>
    <form action="Menu.jsp" method="get">
        <input type="submit" value="Cancel">
    </form>
</body>
</html>

