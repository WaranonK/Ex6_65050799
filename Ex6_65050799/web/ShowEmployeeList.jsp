<%-- 
    Document   : ShowEmployeeList
    Created on : Oct 6, 2025, 2:08:11 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,Model.Employee"%>
<!DOCTYPE html>
<html>
<head><title>Employee List</title></head>
<body>
    <h2>Employee List</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Salary</th><th>Version</th></tr>
        <%
            List<Employee> list = (List<Employee>) request.getAttribute("employees");
            if (list != null) {
                for (Employee e : list) {
        %>
            <tr>
                <td><%= e.getEmployeeid() %></td>
                <td><%= e.getEmployeename() %></td>
                <td><%= e.getSalary() %></td>
                <td><%= e.getVersion() %></td>
            </tr>
        <%
                }
            }
        %>
    </table>
    <p><a href="Menu.jsp">Back to Menu</a></p>
</body>
</html>

