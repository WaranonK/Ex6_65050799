/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;
import jakarta.persistence.PessimisticLockException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeTable{
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6_65050799PU");
    private static final Set<Integer> lockedEmployees = ConcurrentHashMap.newKeySet();
    
    public static List<Employee> findAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Employee.findAll", Employee.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    public static Employee findEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Employee.class, id);
        } finally {
            em.close();
        }
    }

    public static void insertEmployee(Employee emp) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public static void removeEmployee(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Employee emp = em.find(Employee.class, id);
            if (emp != null) {
                em.lock(emp, LockModeType.PESSIMISTIC_WRITE);
                //em.lock(emp, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
                em.remove(emp);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }

        } /*catch (OptimisticLockException e)*/ catch (PessimisticLockException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public static boolean updateEmployee(Employee newEmp) {
        EntityManager em = emf.createEntityManager();
        int empId = newEmp.getEmployeeid();
        synchronized (lockedEmployees) {
            if (lockedEmployees.contains(empId)) {
                System.out.println(" Employee ID " + empId + "is being updated by another user");
                return false;
            }
            lockedEmployees.add(empId); 
        }
        em.getTransaction().begin();
        try {
            Employee emp = em.find(Employee.class, newEmp.getEmployeeid());
            if (emp != null) {
                em.lock(emp, LockModeType.PESSIMISTIC_WRITE);
                //em.lock(emp, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
                System.out.println("Employee ID: " + empId);
                Thread.sleep(7000);
                emp.setEmployeename(newEmp.getEmployeename());
                emp.setSalary(newEmp.getSalary());
                em.merge(emp);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
        }

        } /*catch (OptimisticLockException e) catch (PessimisticLockException e)*/catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            synchronized (lockedEmployees) {
                lockedEmployees.remove(empId);
            }
            em.close();
        }
    }
}
