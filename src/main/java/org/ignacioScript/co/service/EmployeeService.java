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

    private final EmployeeDAO employeeDAO;
    private final LocationService locationService;
    private final JobService jobService;

    public EmployeeService(EmployeeDAO employeeDAO, LocationService locationService, JobService jobService) {
        this.employeeDAO = employeeDAO;
        this.locationService = locationService;
        this.jobService = jobService;
    }


    public void saveEmployee(EmployeeDTO employeeDTO, JobDTO jobDTO, LocationDTO locationDTO) {
        LocalDate hireDate = createLocalDate(employeeDTO.getHireDate());
        Job job = jobService.createJobFromDTO(jobDTO);
        Location location = locationService.createLocationFromDTO(locationDTO);
        Employee employee = createEmployeeFromDTO(employeeDTO, job, location, hireDate);
        employeeDAO.save(employee);
    }

   public void updateEmployee(int id, EmployeeDTO employeeDTO, JobDTO jobDTO, LocationDTO locationDTO){
       LocalDate hireDate = createLocalDate(employeeDTO.getHireDate());
       Job job = jobService.createJobFromDTO(jobDTO);
       Location location = locationService.createLocationFromDTO(locationDTO);
       Employee employee = createEmployeeFromDTO(employeeDTO, job, location, hireDate);

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
                                new JobDTO(
                                        employee.getJobTitle().getJobTitle(),
                                        employee.getJobTitle().getSalary()),
                                new LocationDTO(
                                        employee.getLocation().getProvince(),
                                        employee.getLocation().getCity(),
                                        employee.getLocation().getStreet()),
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
                new JobDTO(
                        employee.getJobTitle().getJobTitle(),
                        employee.getJobTitle().getSalary()),
                new LocationDTO(
                        employee.getLocation().getProvince(),
                        employee.getLocation().getCity(),
                        employee.getLocation().getStreet()),
                employee.getHireDate().toString());
    }


    //HELPERS

    private Employee createEmployeeFromDTO(EmployeeDTO employeeDTO, Job job, Location location, LocalDate date){
        return new Employee(
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getPhoneNumber(),
                employeeDTO.getEmail(),
                job,
                location,
                date
                );
    }


    private LocalDate createLocalDate(String date){
        return  LocalDate.parse(date);
    }
}
