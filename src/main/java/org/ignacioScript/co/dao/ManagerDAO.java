package org.ignacioScript.co.dao;

import org.ignacioScript.co.model.Manager;
import org.ignacioScript.co.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO extends DataAccessObject<Manager>{

    private final LocationDAO locationDAO;

    public ManagerDAO(){
        locationDAO = new LocationDAO();
    }

    private static final String SQL_INSERT = "INSERT INTO manager (firstname, lastname, email, location) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE manager SET firstname=?, lastname=?, email=?, location=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM manager WHERE id=?";
    private static final String SQL_FIND_ALL = "SELECT * FROM manager";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM manager WHERE id=?";

    @Override
    public void save(Manager manager) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT)){
            statement.setString(1, manager.getFirstName());
            statement.setString(2, manager.getLastName());
            statement.setString(3, manager.getEmail());
            statement.setInt(4, manager.getLocation().getLocationId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void update(Manager manager, int id) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)){

            statement.setString(1, manager.getFirstName());
            statement.setString(2, manager.getLastName());
            statement.setString(3, manager.getEmail());
            statement.setInt(4, manager.getLocation().getLocationId());
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
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public List<Manager> findAll() {
        List<Manager> managers = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL)){
            var resultSet = statement.executeQuery();
            while (resultSet.next()){
                var manager = new Manager(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        locationDAO.findById(resultSet.getInt("location"))
                );
                managers.add(manager);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return managers;
    }

    @Override
    public Manager findById(int id) {
        Manager manager;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.absolute(1);
                manager = new Manager(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        locationDAO.findById(resultSet.getInt("location"))
                );
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }


        return manager;
    }
}
