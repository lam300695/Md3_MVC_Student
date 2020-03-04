package com.codegym.conection;

import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PrepareStatement {
    public static void insertRecord(int id, String name) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into demo(id,name ) values (?,?)";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            prepareStatement.setString(2, name);
            int rs = prepareStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateRecord(int id, String newName) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "update demo set name = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,newName);
            preparedStatement.setInt(2,id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRecord(int id) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql ="delete from demo where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        insertRecord(4, "lamlam");
//        updateRecord(4,"PhuongHieu");
        deleteRecord(4);
    }
}
