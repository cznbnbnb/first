package com.chenzheng.event.dao;

import com.chenzheng.event.bean.ScenicComment;
import com.chenzheng.event.bean.ScenicSpots;
import com.chenzheng.event.util.JdbcUtil;

import java.sql.*;
import java.util.LinkedList;

/**
 * @author cz
 * @date 2021/4/22
 */
public class ScenicCommentDaoImp {
    /**
     *关于景点评论表的dao层
     */

    public static void updateScenicComment(LinkedList<ScenicComment> scenicComments){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            for (int i = 0; i < scenicComments.size(); i++) {
                String sql = "update sceniccomment set comment='"+scenicComments.get(i).getComment()+"' where s_id="+scenicComments.get(i).getSid();
                statement.executeUpdate(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection, statement, resultSet);
        }
    }

}
