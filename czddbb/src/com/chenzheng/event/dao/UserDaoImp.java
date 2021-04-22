package com.chenzheng.event.dao;

import com.chenzheng.event.bean.User;
import com.chenzheng.event.util.JdbcUtil;

import java.sql.*;

/**
 * @author cz
 * @date 2021/4/17
 */

/**
 *关于用户表的dao层
 */
public class UserDaoImp implements UserDao{
    /**
     *设置用户的静态类，方便随时取用
     */
    public static User user2 = new User();
    public static User getUser2() {
        return user2;
    }

    /**
     *登录方法，返回到service层
     */
    public boolean login(String username,String password){
        User user1 = new User();
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        int result = 0;
        try {
            String sql = "Select * from `register` where `username`=? and `password`=?";
            connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //防止sql注入
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = 1;
                user1.setId(resultSet.getInt("id"));
                user1.setUsername(resultSet.getString("username"));
                user1.setPassword(resultSet.getString("password"));
                user1.setIdealMoney(resultSet.getInt("idealMoney"));
                user1.setPower(resultSet.getInt("power"));
                user1.setUserClass(resultSet.getString("userClass"));
                user1.setPhoneNumber(resultSet.getString("phoneNumber"));
                user2 = user1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection, statement, resultSet);
        }
        if (result == 1){
            return true;
        }
        return false;
    }
    /**
     *注册方法，返回到service层
     */
    public boolean register(String username1,String password1,String bindNumber1){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            String sql1 = "insert into register(username,password,power,userClass,phoneNumber) value (?,?,?,?,?)";
            String sql2 = "Select * from `register` where `username`=? or `phoneNumber`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            //防止sql注入
            preparedStatement.setString(1,username1);
            preparedStatement.setString(2,bindNumber1);
            resultSet = preparedStatement.executeQuery();
            /**
             *判断账号与手机号是否重复
             */
            if (resultSet.next()) {
                return false;
            }
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement.setString(1,username1);
            preparedStatement.setString(2,password1);
            int a = 1;
            preparedStatement1.setInt(3,a);
            String c = "c";
            preparedStatement1.setString(4,c);
            preparedStatement1.setString(5,bindNumber1);
            preparedStatement1.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection, statement, resultSet);
        }
        return true;
    }
    /**
     *更新方法，实现用户的随时更新
     */
    public static boolean updateUser(User user){
        try {
            Connection connection = null;
            ResultSet resultSet = null;
            Statement statement = null;
            String sql = "update register set username='"+user.getUsername()+"',password='"+user.getPassword()+"',idealMoney='"+user.getIdealMoney()+"' where id="+user.getId();
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            String sql2 = "Select * from `register` where (`username`=? or `phoneNumber`=?) and id != "+user.getId();
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            //防止sql注入
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPhoneNumber());
            resultSet = preparedStatement.executeQuery();
            /**
             *确保更改后账号与手机号的唯一性
             */
            if (resultSet.next()) {
                return false;
            }
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        user2 = user;
        return true;
        }
    }

