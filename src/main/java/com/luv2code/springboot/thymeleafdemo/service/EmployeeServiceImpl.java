package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        log.debug("Fetching all employees ordered by last name");
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findById(int id) {
        log.debug("Fetching employee with id={}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Employee not found with id - " + id));
    }

    @Override
    public Employee save(Employee employee) {
        log.debug("Saving employee: {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(int id, Employee updatedEmployee) {
        log.debug("Updating employee with id={}", id);

        Employee existing = findById(id);
        existing.setFirstName(updatedEmployee.getFirstName());
        existing.setLastName(updatedEmployee.getLastName());
        existing.setEmail(updatedEmployee.getEmail());

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteById(int id) {
        log.debug("Deleting employee with id={}", id);

        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Cannot delete. Employee not found with id - " + id);
        }

        employeeRepository.deleteById(id);
    }
}
