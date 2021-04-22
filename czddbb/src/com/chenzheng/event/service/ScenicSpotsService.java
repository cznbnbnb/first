package com.chenzheng.event.service;

import com.chenzheng.event.bean.ScenicSpots;
import com.chenzheng.event.dao.ScenicSpotsDaoImp;
import com.chenzheng.event.dao.UserDaoImp;
import com.chenzheng.event.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author cz
 * @date 2021/4/20
 */


/**
 *景点的service层
 */
public class ScenicSpotsService {

    ScenicSpotsDaoImp scenicSpotsDaoImp = new ScenicSpotsDaoImp();
    public void load(){
        scenicSpotsDaoImp.load();
    }


    public void search(String inf,int currentPage) {
       scenicSpotsDaoImp.search(inf,currentPage);
    }


}
