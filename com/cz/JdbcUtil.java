package com.cz;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author cz
 * @date 2021/4/8
 */
public class JdbcUtil {
    public static Connection getConnection() {
        Properties properties = new Properties();
        Connection conn = null;
        try {
            properties.load(Login.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            String url = properties.getProperty("mysql.url");
            String user = properties.getProperty("mysql.user");
            String password = properties.getProperty("mysql.password");
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public  static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException throwables){
            throwables.printStackTrace();
            }
        }
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (SQLException throwable){
                throwable.printStackTrace();
            }
        }

    }
}
