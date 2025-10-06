/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Employee;
import Model.EmployeeTable;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PessimisticLockException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateEmployeeServlet", urlPatterns = {"/UpdateEmployeeServlet"})
public class UpdateEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("search".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee emp = EmployeeTable.findEmployeeById(id);
            if (emp != null) {
                request.setAttribute("emp", emp);
                request.getRequestDispatcher("UpdateEmployeeForm.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Employee not found");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double salary = Double.parseDouble(request.getParameter("salary"));

            Employee newEmp = new Employee(id, name, salary);
            boolean success = EmployeeTable.updateEmployee(newEmp);
            if(!success){
                request.setAttribute("message", "Sorry this record is being updated by another user. Please try again later");
            }
            else{
                request.setAttribute("message", "Update Successfully");
            }
            List<Employee> empList = EmployeeTable.findAllEmployees();
            request.setAttribute("employees", empList);
            request.getRequestDispatcher("UpdateEmployeeResult.jsp").forward(request, response);

        } /*catch (OptimisticLockException ex)*/catch (PessimisticLockException ex) {
            request.setAttribute("error", "Sorry this record is being updated by another user. Please try again later");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

