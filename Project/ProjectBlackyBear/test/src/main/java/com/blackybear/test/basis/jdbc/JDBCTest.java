package com.blackybear.test.basis.jdbc;

import com.blackybear.common.Util;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.sql.*;
import java.util.Properties;

/**
 * Description: JDBC
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * 1. 通过DriverManager创建连接，每个连接对应一个物理连接，每次创建都需要打开一个物理连接
 * 2. 通过数据连接池创建连接，系统会主动建立一定数量的连接，使用连接时不用重复打开物理连接，释放资源后仍然保持物理连接
 */
public class JDBCTest {
    private static final String DBCPCONFIGPROPERTIES = "/resource/dbcpconfig.properties";
    private static final String SQL = "select * from area";
    private static final String SQL_PRO = "call sp_test();";

    public static void main(String[] args) {
        testPro();
    }

    //调用存储过程
    private static void testPro() {
        Properties properties = Util.getProperties(JDBCTest.class, DBCPCONFIGPROPERTIES);
        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(SQL);
            callableStatement = connection.prepareCall(SQL_PRO);
            connection.setAutoCommit(false);
            callableStatement.executeQuery();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int areaId = resultSet.getInt("area_id");
                String areaName = resultSet.getString("area_name");
                System.out.println("Id : " + areaId + " Name : " + areaName);
            }
            connection.rollback();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connection);
        }
    }

    //JDBC连接数据库
    @SuppressWarnings("unused")
    private static void testDriverManager() {
        Properties properties = Util.getProperties(JDBCTest.class, DBCPCONFIGPROPERTIES);
        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int areaId = resultSet.getInt("area_id");
                String areaName = resultSet.getString("area_name");
                System.out.println("Id : " + areaId + " Name : " + areaName);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connection);
        }
    }

    //数据库连接池连接数据库
    @SuppressWarnings("unused")
    private static void testDBCP() {
        Properties properties = Util.getProperties(JDBCTest.class, DBCPCONFIGPROPERTIES);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            BasicDataSource basicDataSourceFactory = BasicDataSourceFactory.createDataSource(properties);
            connection = basicDataSourceFactory.getConnection();
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int areaId = resultSet.getInt("area_id");
                String areaName = resultSet.getString("area_name");
                System.out.println("Id : " + areaId + " Name : " + areaName);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connection);
        }
    }

    //释放数据库资源
    private static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        if (connection != null)
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
    }
}

