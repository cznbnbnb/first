package com.chenzheng.event.dao;

import com.chenzheng.event.bean.ScenicSpots;
import com.chenzheng.event.util.JdbcUtil;

import java.sql.*;
import java.util.LinkedList;

/**
 * @author cz
 * @date 2021/4/18
 */

/**
 *关于景点表的dao层
 */
public class ScenicSpotsDaoImp {

    public static LinkedList<ScenicSpots> scenicSpots = null;
    public static LinkedList<ScenicSpots> scenicSpots2 = new LinkedList<ScenicSpots>();;
    public void load(){
        Connection connection1 = null;
        ResultSet resultSet1 = null;
        Statement statement1 = null;
        scenicSpots = new LinkedList<ScenicSpots>();
        try {
            connection1 = JdbcUtil.getConnection();
            String sql1 = "Select * from scenicspot";
            PreparedStatement preparedStatement1 = connection1.prepareStatement(sql1);
            resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                ScenicSpots scenicSpots1 = new ScenicSpots( resultSet1.getInt("s_id"), resultSet1.getString("s_name"), resultSet1.getInt("ticketsPrice"), resultSet1.getString("s_information"), resultSet1.getInt("ticketsNumber"), resultSet1.getDate("s_date"));
                scenicSpots.add(scenicSpots1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection1, statement1, resultSet1);
        }
    }
    public static void updateScenicSpots(LinkedList<ScenicSpots> scenicSpots){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            for (int i = 0;i < scenicSpots.size(); i++) {
                String sql = "update scenicspot set s_name='"+scenicSpots.get(i).getsName()+"',s_information='"+scenicSpots.get(i).getInformation()+"',ticketsNumber='"+scenicSpots.get(i).getTicketNumber()+"',s_date='"+scenicSpots.get(i).getDate()+"',ticketsPrice='"+scenicSpots.get(i).getTicketPrice()+"' where s_id="+scenicSpots.get(i).getSid();
                statement.executeUpdate(sql);
                System.out.println(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection, statement, null);
        }
        scenicSpots2 = scenicSpots;
    }


    public void search(String inf,int currentPage) {
        Connection connection1 = null;
        ResultSet resultSet1 = null;
        Statement statement1 = null;
        Integer q = (currentPage - 1)*5 ;
        Integer h = currentPage * 5;
        scenicSpots2.clear();
        try {
            connection1 = JdbcUtil.getConnection();
            String sql1 = "Select * from scenicspot where s_information like'%" + inf + "%'LIMIT " +q.toString()+","+h.toString();
            PreparedStatement preparedStatement1 = connection1.prepareStatement(sql1);
            resultSet1 = preparedStatement1.executeQuery();
            System.out.println(sql1);
            while (resultSet1.next()) {
                ScenicSpots sce = new ScenicSpots( resultSet1.getInt("s_id"), resultSet1.getString("s_name"), resultSet1.getInt("ticketsPrice"), resultSet1.getString("s_information"), resultSet1.getInt("ticketsNumber"), resultSet1.getDate("s_date"));
                scenicSpots2.add(sce);
                System.out.println(sce);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection1, statement1, resultSet1);
        }
    }



}
