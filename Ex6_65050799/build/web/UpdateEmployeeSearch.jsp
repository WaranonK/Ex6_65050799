<%-- 
    Document   : UpdateEmployeeSearch
    Created on : Oct 6, 2025, 2:06:49 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Search Employee to Update</title></head>
<body>
    <h2>Enter Employee ID to Update</h2>
    <form action="UpdateEmployeeServlet" method="get">
        <input type="hidden" name="action" value="search">
        ID: <input type="number" name="id" required>
        <input type="submit" value="Search">
    </form>
</body>
</html>

