package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.EmployeeDAO;
import org.ignacioScript.co.dto.EmployeeDTO;
import org.ignacioScript.co.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public void updateEmployee(Employee employee, int id) {
        employeeDAO.update(employee, id);
    }

    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }

    public List<EmployeeDTO> findAllEmployees() {
        return employeeDAO.findAll().stream()
                .map(employee -> new EmployeeDTO(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getEmail(),
                                employee.getPhoneNumber(),
                                employee.getJobTitle(),
                                employee.getLocation())
                        ).collect(Collectors.toList());
    }

    public EmployeeDTO findEmployeeById(int id) {
        Employee employee = employeeDAO.findById(id);
        return new EmployeeDTO(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getJobTitle(),
                employee.getLocation());
    }
}
