/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tianyang Li
 */
public class DerbyUtil {
    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    static String dbName = "database\\cinema\\";
    
    public static boolean test = false;
    
    static{
        loadDriver();
    }

    /**
     * Load database driver
     */
    static void loadDriver() {
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
        }
    }

    /**
     * Get a database connection
     * @return 
     */
    public static Connection getConn() {
        if(test){
            return getTestConn();
        }else{
            return getRealConn();
        }
    }
    /**
     * Get a database connection
     * @return 
     */
    public static Connection getRealConn() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(protocol + dbName);
        } catch (SQLException e) {
        }
        return conn;
    }
    /**
     * Gets the test database connection
     * @return 
     */
    public static Connection getTestConn(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(protocol + "database\\cinematest\\");
        } catch (SQLException e) {
        }
        return conn;
    }
    /**
     * Close the database connection
     * @param conn 
     */
    public static void close(Connection conn){
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
        }
    }
}
