package com.chenzheng.event.dao;

import com.chenzheng.event.bean.OrderFormInformation;
import com.chenzheng.event.bean.ScenicComment;
import com.chenzheng.event.bean.ScenicSpots;
import com.chenzheng.event.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author cz
 * @date 2021/4/22
 */

/**
 *关于订单表的dao层
 */
public class OrderFormDaoImp {
    public static LinkedList<OrderFormInformation> ord = new LinkedList<>();
    public static void updateScenicComment(LinkedList<ScenicComment> scenicComments){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            for (int i = 0; scenicComments != null; i++) {
                String sql = "update sceniccomment set comment='"+scenicComments.get(i).getComment()+"' where s_id="+scenicComments.get(i).getSid();
                statement.executeUpdate(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection, statement, resultSet);
        }

    }

    public void getOrderForm(int currentPage) {
        Connection connection1 = null;
        ResultSet resultSet1 = null;
        Statement statement1 = null;
        Integer q = (currentPage - 1) * 8;
        Integer h = currentPage * 8;
        ord.clear();
        String sql1;
        try {
            connection1 = JdbcUtil.getConnection();
            sql1 = "Select * from orderformhistory where u_id = " +UserDaoImp.user2.getId()+" LIMIT " +q.toString()+","+h.toString();
            PreparedStatement preparedStatement1 = connection1.prepareStatement(sql1);
            resultSet1 = preparedStatement1.executeQuery();
            System.out.println(sql1);
            while(resultSet1.next()) {
                OrderFormInformation order = new OrderFormInformation(resultSet1.getDate("orderFormDate"), resultSet1.getInt("u_id"), resultSet1.getInt("s_id"), resultSet1.getInt("orderFormPrice")) ;
                ord.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection1, statement1, resultSet1);
        }
    }
    public void setOrderForm(OrderFormInformation orderFormInformation) {
        Connection connection1 = null;
        ResultSet resultSet1 = null;
        Statement statement1 = null;
        ord.clear();
        String sql1;
        try {
            connection1 = JdbcUtil.getConnection();
            sql1 = "insert into orderformhistory(orderFormDate,u_id,s_id,orderFormPrice) value (?,?,?,?)";
            PreparedStatement preparedStatement1 = connection1.prepareStatement(sql1);
            preparedStatement1.setDate(1, (Date) orderFormInformation.getOrderFormDate());
            preparedStatement1.setInt(2,orderFormInformation.getU_id());
            preparedStatement1.setInt(3,orderFormInformation.getS_id());
            preparedStatement1.setInt(4,orderFormInformation.getOrderFormPrice());
            preparedStatement1.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection1, statement1, resultSet1);
        }
    }
}
