package org.ignacioScript.co.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DBConfig {

    private static final Dotenv dotenv = Dotenv.configure().load();


    public static String getDBURL(){
        return dotenv.get("DB_URL");
    }
    public static String getDBUSER(){
        return dotenv.get("DB_USER");
    }
    public static String getDBPASS(){
        return dotenv.get("DB_PASS");
    }
}
