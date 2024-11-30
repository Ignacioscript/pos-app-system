package org.ignacioScript.co.controller;

import org.ignacioScript.co.dto.EmployeeDTO;
import org.ignacioScript.co.model.Employee;
import org.ignacioScript.co.service.EmployeeService;

import java.util.List;

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public EmployeeController(){
        this.employeeService = new EmployeeService();
    }

    public void saveEmployee(Employee employee){
        employeeService.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee, int id){
        employeeService.updateEmployee(employee, id);
    }

    public void deleteEmployee(int id){
        employeeService.deleteEmployee(id);
    }

    public List<EmployeeDTO> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    public EmployeeDTO findEmployeeById(int id){
        return employeeService.findEmployeeById(id);
    }


}
