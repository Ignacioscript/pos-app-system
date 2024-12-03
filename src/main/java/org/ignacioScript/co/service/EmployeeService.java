package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.EmployeeDAO;
import org.ignacioScript.co.dto.EmployeeDTO;
import org.ignacioScript.co.dto.JobDTO;
import org.ignacioScript.co.dto.LocationDTO;
import org.ignacioScript.co.model.Employee;
import org.ignacioScript.co.model.Job;
import org.ignacioScript.co.model.Location;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    public void saveEmployee(EmployeeDTO employeeDTO, JobDTO jobDTO, LocationDTO locationDTO) {
        String date = employeeDTO.getHireDate();
        LocalDate hireDate = LocalDate.parse(date);

        Job job = new Job(jobDTO.getJobTitle(), jobDTO.getSalary());
        Location location = new Location(locationDTO.getProvince(), locationDTO.getCity(), locationDTO.getStreet());
        Employee employee = new Employee(
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getPhoneNumber(),
                employeeDTO.getEmail(),
                job,
                location,
                hireDate
                );

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
                                new JobDTO(employee.getJobTitle().getJobTitle(), employee.getJobTitle().getSalary()),
                                new LocationDTO(employee.getLocation().getProvince(), employee.getLocation().getCity(), employee.getLocation().getStreet()),
                                employee.getHireDate().toString()))
                                .collect(Collectors.toList());
    }

    public EmployeeDTO findEmployeeById(int id) {
        Employee employee = employeeDAO.findById(id);
        return new EmployeeDTO(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                new JobDTO(employee.getJobTitle().getJobTitle(), employee.getJobTitle().getSalary()),
                new LocationDTO(employee.getLocation().getProvince(), employee.getLocation().getCity(), employee.getLocation().getStreet()),
                employee.getHireDate().toString());
    }
}
