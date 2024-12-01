package org.ignacioScript.co.dao;

import org.ignacioScript.co.model.Job;
import org.ignacioScript.co.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAO extends DataAccessObject<Job> {


    private static final String SQL_INSERT = "INSERT INTO jobs (job_title, salary) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE jobs SET job_title = ?, salary = ? WHERE job_id = ?";
    private static final String SQL_DELETE = "DELETE FROM jobs WHERE job_id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM jobs";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM jobs WHERE job_id = ?";

    @Override
    public void save(Job job) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT)){
            statement.setString(1, job.getJobTitle());
            statement.setDouble(2, job.getSalary());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Job job, int id) {
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)){
            statement.setString(1, job.getJobTitle());
            statement.setDouble(2, job.getSalary());
            statement.setInt(3, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Job> findAll() {
        List<Job> jobs = new ArrayList<>();
        Job job;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                job = new Job(resultSet.getInt("job_id"),
                        resultSet.getString("job_title"),
                        resultSet.getDouble("salary"));
                jobs.add(job);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return jobs;
    }

    @Override
    public Job findById(int id) {
        Job job;
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.absolute(1);
                job = new Job(resultSet.getInt("job_id"),
                        resultSet.getString("job_title"),
                        resultSet.getDouble("salary"));

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return job;
    }
}
