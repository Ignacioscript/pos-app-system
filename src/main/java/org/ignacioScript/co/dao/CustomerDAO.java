package org.ignacioScript.co.dao;

import org.ignacioScript.co.model.Customer;
import org.ignacioScript.co.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends DataAccessObject<Customer>{


    private final String CREATE ="INSERT INTO customers (firstname, lastname, email, phoneNumber) VALUES(?,?,?,?)";
    private final String UPDATE = "UPDATE customers SET firstname=?, lastname=?, email=?, phoneNumber=? WHERE id=?";
    private final String DELETE = "DELETE FROM customers WHERE id=?";
    private final String FIND_ALL = "SELECT * FROM customers";
    private final String FIND_BY_ID = "SELECT * FROM customers WHERE id=?";


    @Override
    public void save(Customer customer) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE)){
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhoneNumber());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();

            throw new RuntimeException();
        }
    }

    @Override
    public void update(Customer customer, int id) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhoneNumber());
            statement.setInt(5, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                customer = new Customer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"));
                customers.add(customer);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.absolute(1);
                customer = new Customer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"));

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return customer;
    }
}
