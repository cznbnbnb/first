package com.cz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author cz
 * @date 2021/4/9
 */
public class Register {
   public static void register(){
      Connection connection = null;
      ResultSet resultSet = null;
      Statement statement = null;

      try {
         String sql = "insert into register(username,password) value (?,?)";
         connection = JdbcUtil.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         int exit1 = 0;
         Scanner input = new Scanner(System.in);
         System.out.println("请输入新用户：");
         String username = input.next();
         preparedStatement.setString(1,username);
         System.out.println("请输入密码：");
         String password = input.next();
         preparedStatement.setString(2,password);
         preparedStatement.execute();
         System.out.println("注册成功，按任意键退出");
         input.next();
      }catch (Exception e){
         e.printStackTrace();
      }finally {
         JdbcUtil.closeAll(connection, statement, resultSet);
      }return;


   }


}
