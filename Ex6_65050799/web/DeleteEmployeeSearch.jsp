<%-- 
    Document   : DeleteEmployeeSearch
    Created on : Oct 6, 2025, 2:07:27 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Delete Employee</title></head>
<body>
    <h2>Enter Employee ID to Delete</h2>
    <form action="DeleteEmployeeServlet" method="get">
        <input type="hidden" name="action" value="search">
        ID: <input type="number" name="id" required>
        <input type="submit" value="Search">
    </form>
</body>
</html>
