package org.sergeyneuymin.spring.springboot.spring_course_springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Parameter;
import jakarta.persistence.Query;
import jakarta.persistence.TemporalType;
import jakarta.transaction.Transactional;


import org.sergeyneuymin.spring.springboot.spring_course_springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    public List<Employee> getAllEmployees() {

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        //Session session = entityManager.unwrap(Session.class);
        //session.saveOrUpdate(employee);

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {

//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class,id);

        Employee employee = entityManager.find(Employee.class,id);

        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeID");
//        query.setParameter("employeeID",id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee where id =:employeeID");
        query.setParameter("employeeID",id);
        query.executeUpdate();
    }
}
