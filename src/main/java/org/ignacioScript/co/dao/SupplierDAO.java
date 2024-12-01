package org.ignacioScript.co.dao;

import org.ignacioScript.co.model.Supplier;
import org.ignacioScript.co.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO extends DataAccessObject<Supplier>{

    private final LocationDAO locationDAO;

    public SupplierDAO(){
        locationDAO = new LocationDAO();
    }

    private final String CREATE ="INSERT INTO suppliers (supplier_name, location) VALUES(?,?)";
    private final String UPDATE = "UPDATE suppliers SET supplier_name=?, location=? WHERE id=?";
    private final String DELETE = "DELETE FROM suppliers WHERE id=?";
    private final String FIND_ALL = "SELECT * FROM suppliers";
    private final String FIND_BY_ID = "SELECT * FROM suppliers WHERE id=?";

    @Override
    public void save(Supplier supplier) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE)){
            statement.setString(1, supplier.getSupplierName());
            statement.setInt(2, supplier.getLocation().getLocationId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }


    }

    @Override
    public void update(Supplier supplier, int id) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1, supplier.getSupplierName());
            statement.setInt(2, supplier.getLocation().getLocationId());
            statement.setInt(3, id);
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
    public List<Supplier> findAll() {
        List<Supplier> suppliers = new ArrayList<>();
        Supplier supplier;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery()){
            while(rs.next()){
                supplier = mapResultToSupplier(rs);
                suppliers.add(supplier);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return suppliers;
    }

    @Override
    public Supplier findById(int id) {
        Supplier supplier;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.absolute(1);
            supplier = mapResultToSupplier(rs);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return supplier;
    }

    private Supplier mapResultToSupplier(ResultSet rs) throws SQLException {
        return new Supplier(
            rs.getInt("id"),
            rs.getString("supplier_name"),
            locationDAO.findById(rs.getInt("location"))
        );
    }
}
