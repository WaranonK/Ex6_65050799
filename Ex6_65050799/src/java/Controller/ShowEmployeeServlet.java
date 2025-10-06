/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.EmployeeTable;
import Model.Employee;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowEmployeeServlet", urlPatterns = {"/ShowEmployeeServlet"})
public class ShowEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employees = EmployeeTable.findAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("ShowEmployeeList.jsp").forward(request, response);
    }
}

