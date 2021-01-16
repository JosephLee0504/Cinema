/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tianyang Li
 */
public class UseDB {

    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    String dbName = "database\\cinema\\";

    static void loadDriver() {
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
        }
    }

    public void doIt() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        System.out.println("starting");
        try {
            conn = DriverManager.getConnection(protocol + dbName);
//                    + ";create=true");
        } catch (SQLException e) {
        }

        System.out.println("Connected to and created database " + dbName);

        try {

            s = conn.createStatement();
            rs = s.executeQuery("select * from accounts");

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e1) {
        }
        try {
            conn.close();
            conn = null;
            s.close();
            s = null;
            rs.close();
            rs = null;
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        UseDB t = new UseDB();
        UseDB.loadDriver();
        t.doIt();
    }
}
