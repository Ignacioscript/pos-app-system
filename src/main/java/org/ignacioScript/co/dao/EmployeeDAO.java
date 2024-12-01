package org.ignacioScript.co.dao;

import org.ignacioScript.co.model.Employee;
import org.ignacioScript.co.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DataAccessObject<Employee>{


    private final LocationDAO locationDAO;
    private final JobDAO jobDAO;

    public EmployeeDAO(){
        locationDAO = new LocationDAO();
        jobDAO = new JobDAO();
    }


    private static final String SQL_INSERT = "INSERT INTO employee (firstname, lastname, email, jobtitle, department, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE employee SET firstname=?, lastname=?, email=?, jobtitle=?, department=?, hire_date=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM employee WHERE id=?";
    private static final String SQL_FIND_ALL = "SELECT * FROM employee";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM employee WHERE id=?";




    @Override
    public void save(Employee employee) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT)){
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getJobTitle().getJobId());
            statement.setInt(5, employee.getLocation().getLocationId());
            statement.setString(6, employee.getHireDate().toString());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void update(Employee employee, int id) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)){

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getJobTitle().getJobId());
            statement.setInt(5, employee.getLocation().getLocationId());
            statement.setString(6, employee.getHireDate().toString());
            statement.setInt(7, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        Employee employee;
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        jobDAO.findById(rs.getInt("jobtitle")),
                        locationDAO.findById(rs.getInt("location")),
                        rs.getDate("hiredate").toLocalDate());
                employees.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.absolute(1);
            employee = new Employee(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getString("phoneNumber"),
                    jobDAO.findById(rs.getInt("jobtitle")),
                   locationDAO.findById(rs.getInt("location")),
                    rs.getDate("hiredate").toLocalDate());
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return employee;
    }
}
