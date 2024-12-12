package org.ignacioScript.co.controller;

import org.ignacioScript.co.dto.EmployeeDTO;
import org.ignacioScript.co.service.EmployeeService;

import java.util.List;

public class EmployeeController {

    private final EmployeeService employeeService;

    public  EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public void saveEmployee(EmployeeDTO employeeDTO){
        employeeService.saveEmployee(employeeDTO, employeeDTO.getJobTitle(), employeeDTO.getLocation());

    }

    public void updateEmployee(int id, EmployeeDTO employeeDTO){

        employeeService.updateEmployee(id, employeeDTO, employeeDTO.getJobTitle(), employeeDTO.getLocation());
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
