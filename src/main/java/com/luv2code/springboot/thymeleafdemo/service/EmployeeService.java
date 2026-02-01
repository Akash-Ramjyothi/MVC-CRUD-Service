package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Fetch all employees ordered by last name.
     */
    List<Employee> findAll();

    /**
     * Find an employee by id.
     * @throws jakarta.persistence.EntityNotFoundException if not found
     */
    Employee findById(int id);

    /**
     * Create or persist a new employee.
     */
    Employee save(Employee employee);

    /**
     * Update an existing employee by id.
     * @throws jakarta.persistence.EntityNotFoundException if not found
     */
    Employee update(int id, Employee employee);

    /**
     * Delete an employee by id.
     * @throws jakarta.persistence.EntityNotFoundException if not found
     */
    void deleteById(int id);
}
