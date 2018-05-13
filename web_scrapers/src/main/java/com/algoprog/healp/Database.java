package com.algoprog.healp;

import java.sql.*;

/**
 * Created by Chris on 17/9/2017.
 */
public class Database {
    private static Connection conn = null;

    /**
     * Connects to the MySQL database
     * @return
     */
    public static boolean connect() {

        //Utils.print("Connecting to MySQL database...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            return false;
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healp?useUnicode=yes&characterEncoding=UTF-8", "root", "");
            if (conn != null) {
                //Utils.print("Connected to MySQL database!");
                return true;
            } else {
                //Utils.print("MySQL connection error");
                return false;
            }
        } catch (SQLException e) {
            //Utils.print("MySQL connection error");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns a result set for a SELECT query
     * @param query
     * @return a result set with rows from the database
     */
    public static ResultSet getQuery(String query) {
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Executes UPDATE and DELETE queries
     * @param query
     */
    public static void updateQuery(String query) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
