package com.codegym.conection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {
    public static void InsertRecord(int id, String name) {
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into demo(id, name) VALUES (4,'LamAntony')";
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRecord(int id, String newName) {
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "update demo set name ='" + newName + "' where id = " + id;
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRecord(int id) {
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "delete from demo where id =" + id;
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        InsertRecord(4, "LamAntony");
//        updateRecord(4, "Baby");
        deleteRecord(3);
    }
}
