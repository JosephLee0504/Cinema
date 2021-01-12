/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zhch
 */
public class DerbyUtil {
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:";
    static String dbName = "database\\cinema\\";
    
    static{
        loadDriver();
    }

    static void loadDriver() {
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(protocol + dbName);
//                    + ";create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
            conn = null;
//            s.close();
//            s = null;
//            rs.close();
//            rs = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
