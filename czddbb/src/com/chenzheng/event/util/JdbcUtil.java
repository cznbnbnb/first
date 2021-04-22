package com.chenzheng.event.util;

import com.chenzheng.event.controller.LoginController;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author cz
 * @date 2021/4/8
 */

/**
 *与数据库连接的工具类
 */
public class JdbcUtil {
    public static Connection getConnection(){
        Properties properties = new Properties();

        try {
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("com/chenzheng/event/util/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("mysql.url");
        String user = properties.getProperty("mysql.user");
        String password = properties.getProperty("mysql.password");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){//这里是快速关闭
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
