package org.ignacioScript.co.utils;

import org.ignacioScript.co.config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static final String URL =  DBConfig.getDBURL();
    private static final String USER = DBConfig.getDBUSER();
    private static final String PASS = DBConfig.getDBPASS();


    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASS);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Connection Failed");
        }
    }

    public static void testConnection() {
        if(getConnection()!=null){
            System.out.println("connection success");
        }


    }

}
