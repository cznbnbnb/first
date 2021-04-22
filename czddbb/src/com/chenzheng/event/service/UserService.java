package com.chenzheng.event.service;

import com.chenzheng.event.bean.User;
import com.chenzheng.event.dao.UserDaoImp;
import com.chenzheng.event.util.JdbcUtil;


import java.sql.*;



/**
 * @author cz
 * @date 2021/4/20
 */


/**
 *用户的service层
 */
public class UserService {
    UserDaoImp userDaoImp = new UserDaoImp();
    public boolean login(String username,String password){
       return userDaoImp.login(username,password);
    }

    public boolean register(String username1,String password1,String bindNumber1){
      return userDaoImp.register(username1,password1,bindNumber1);
    }



}
