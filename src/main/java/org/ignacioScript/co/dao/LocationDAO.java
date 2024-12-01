package org.ignacioScript.co.dao;

import org.ignacioScript.co.model.Location;
import org.ignacioScript.co.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO extends DataAccessObject<Location>{


    private static final String INSERT = "INSERT INTO location (province, city, street) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE location SET province = ?, city = ?, street = ? WHERE location_id = ?";
    private static final String DELETE = "DELETE FROM location WHERE location_id = ?";
    private static final String FIND_ALL = "SELECT * FROM location";
    private static final String FIND_BY_ID = "SELECT * FROM location WHERE location_id = ?";

    @Override
    public void save(Location location) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1, location.getProvince());
            statement.setString(2, location.getCity());
            statement.setString(3, location.getStreet());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void update(Location location, int id) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1, location.getProvince());
            statement.setString(2, location.getCity());
            statement.setString(3, location.getStreet());
            statement.setInt(4, id);
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
    public List<Location> findAll() {
        List<Location> locations = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Location location = new Location(
                        resultSet.getInt("location_id"),
                        resultSet.getString("province"),
                        resultSet.getString("city"),
                        resultSet.getString("street"));
                locations.add(location);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return locations;
    }

    @Override
    public Location findById(int id) {
        Location location;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            location = new Location(
                    resultSet.getInt("location_id"),
                    resultSet.getString("province"),
                    resultSet.getString("city"),
                    resultSet.getString("street"));
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return location;
    }
}
