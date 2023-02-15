package org.sergeyneuymin.spring.springboot.spring_course_springboot.service;



import jakarta.transaction.Transactional;
import org.sergeyneuymin.spring.springboot.spring_course_springboot.dao.EmployeeDAO;
import org.sergeyneuymin.spring.springboot.spring_course_springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;


    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {

        employeeDAO.saveEmployee(employee);

    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
