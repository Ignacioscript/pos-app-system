package org.ignacioScript.co.dao;

import org.ignacioScript.co.model.Category;
import org.ignacioScript.co.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DataAccessObject<Category>{


    @Override
    public void save(Category category) {
        String INSERT = "insert into categories (name, description) values (?,?)";
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1,category.getCategoryName());
            statement.setString(2,category.getDescription());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Category category, int id) {
        String UPDATE = "update categories set name = ?, description = ? where id = ?";
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1,category.getCategoryName());
            statement.setString(2,category.getDescription());
            statement.setInt(3,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String DELETE = "delete from categories where id = ?";
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Category category;
        String FIND_ALL = "select * from categories";
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                category = new Category(
                        resultSet.getInt("categoryId"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return categories;
    }

    @Override
    public Category findById(int id) {
        Category category;
        String FIND_BY_ID = "select * from categories where id = ?";
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.absolute(1);
            category = new Category(
                    resultSet.getInt("categoryId"),
                    resultSet.getString("name"),
                    resultSet.getString("description")
            );
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return category;
    }
}
