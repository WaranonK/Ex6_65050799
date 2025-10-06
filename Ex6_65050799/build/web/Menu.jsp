<%-- 
    Document   : Menu
    Created on : Oct 6, 2025, 2:06:01 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
</head>
<body>
    <h2>Employee Management Menu</h2>
    <form action="AddEmployee.jsp" method="get">
        <input type="submit" value="Add Employee">
    </form>
    <form action="UpdateEmployeeSearch.jsp" method="get">
        <input type="submit" value="Update Employee">
    </form>
    <form action="DeleteEmployeeSearch.jsp" method="get">
        <input type="submit" value="Delete Employee">
    </form>
    <form action="ShowEmployeeServlet" method="get">
        <input type="submit" value="Show Employee List">
    </form>
</body>
</html>

