package org.ignacioScript.co.dao;

import org.ignacioScript.co.model.Product;
import org.ignacioScript.co.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DataAccessObject<Product>{


    private final String CREATE = "INSERT INTO products (name, description, quantity_stock, price, category) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE products SET name=?, description=?, quantity_stock=?, price=?, category=? WHERE id=? ";
    private final String DELETE = "DELETE FROM products WHERE id=? ";
    private final String FIND_ALL = "SELECT id, name, description, quantity_stock, price, category FROM product";
    private final String FIND_BY_ID = "SELECT id, name, description, quantity_stock, price, category FROM product WHERE id=?";


    @Override
    public void save(Product product) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE)){
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setInt(3, product.getQuantityStock());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getCategory().getCategoryId());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Product product, int id) {
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setInt(3, product.getQuantityStock());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getCategory().getCategoryId());
            statement.setInt(6, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Product product;
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(FIND_ALL)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                product = new Product(
                        rs.getInt("productId"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("quantity_stock"),
                        rs.getDouble("price"),
                        new CategoryDAO().findById(rs.getInt("categoryId"))
                );
                products.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);

        }


        return products;
    }

    @Override
    public Product findById(int id) {
        Product product;
        try(Connection connection = DBUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.absolute(1);
            product = new Product(
                    rs.getInt("productId"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("quantity_stock"),
                    rs.getDouble("price"),
                    new CategoryDAO().findById(rs.getInt("category"))
            );

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return product;
    }
}
