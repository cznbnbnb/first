package com.cz;

import java.sql.*;
import java.util.Scanner;

/**
 * @author cz
 * @date 2021/4/7
 */
public class Login {
    public static void login(){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            String sql = "Select * from register where username=? and password=?";
            connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int exit1 = 0;
            do {


            Scanner input = new Scanner(System.in);
            System.out.println("请输入账号：");
            String username = input.next();
            System.out.println("请输入密码：");
            String password = input.next();
            preparedStatement.setObject(1,username);
            preparedStatement.setObject(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("登录成功！");
                break;
            }else {
                System.out.println("登录失败！");
            }

                System.out.println("输入0继续，输任意键退出");
                exit1 = input.nextInt();
            }while (exit1 == 0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection, statement, resultSet);
        }




    }

}
