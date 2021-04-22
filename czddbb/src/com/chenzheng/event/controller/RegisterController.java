package com.chenzheng.event.controller;

/**
 * @author cz
 * @date 2021/4/13
 */
import com.chenzheng.event.service.UserService;
import com.chenzheng.event.util.JdbcUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * 注册窗口的控制器
 */
public class RegisterController implements Initializable {
    public static String t1;
    public static String t2;
    public static String t3;
    @FXML
    private Button cancel;
    @FXML
    private TextField newUser;
    @FXML
    private Button confirmRegister;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField confirmPassword;
    @FXML
    private TextField bindNumber;
    @FXML
    public String getnu() { return newUser.getText(); }
    @FXML
    public String getnp() { return newPassword.getText(); }
    @FXML
    public String getcp() { return confirmPassword.getText(); }
    @FXML
    public String getbn() { return bindNumber.getText(); }

    /**
     *确认注册按键，用于连接user的service层并调用注册方法
     */
    @FXML
    void conR(ActionEvent event) {
        /**
         *根据不同地方的if判断给提示页面的标签赋予不同的值
         */
        if (getnp().equals(getcp())){
            UserService userService = new UserService();
            /**
             *控制账号与密码的长度均小于等于十个字节
             */
            if ((getnu().length() <= 10)&&(getnp().length() <= 10)){
                /**
                 *根据注册方法返回的布尔值判断是否注册成功
                 */
                if(userService.register(getnu(),getnp(),getbn())){
                    /**
                     *给提示页面的标签赋值
                     */
                    t1 = "注册成功！";
                    Stage stage = new Stage();
                    Stage1 commonStage = new Stage1();
                    try {
                        commonStage.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    /**
                     *给提示页面的标签赋值
                     */
                    t1 = "注册失败！";
                    t3 = "信息错误,账号或手机号重复！";
                    Stage stage = new Stage();
                    Stage1 commonStage = new Stage1();
                    try {
                        commonStage.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else{
                /**
                 *给提示页面的标签赋值
                 */
                t1 = "注册失败！";
                t3 = "格式错误,账号密码均必须小于十个字符！";
                Stage stage = new Stage();
                Stage1 commonStage = new Stage1();
                try {
                    commonStage.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            /**
             *给提示页面的标签赋值
             */
            t1 = "注册失败！";
            t2 = "两次输入的密码不一致。";
            Stage stage = new Stage();
            Stage1 commonStage = new Stage1();
            try {
                commonStage.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
    @FXML
    void cancel(ActionEvent event) {
        /**
         * 取消按键，没啥好说的，关闭这个页面
         */
        Stage sta = (Stage)cancel.getScene().getWindow();
        sta.close();
    }

    /**
     *注册界面初始化，也没啥好初始化的
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }




}
