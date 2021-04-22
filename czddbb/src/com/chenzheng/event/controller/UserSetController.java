package com.chenzheng.event.controller;

import com.chenzheng.event.dao.UserDaoImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author cz
 * @date 2021/4/13
 */
public class UserSetController implements Initializable {


    @FXML
    private ToggleButton orderForm;
    @FXML
    private Button tc1;
    @FXML
    private TextField text3;
    @FXML
    private Button tc4;
    @FXML
    private ToggleButton recharge;
    @FXML
    private TextField text4;
    @FXML
    private Button tc3;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private ToggleButton userSet;
    @FXML
    private ToggleButton homepage;
    /**
     *点击转跳到主页
     */
    @FXML
    void homepage(ActionEvent event) {
        Stage stage = new Stage();
        Homepage homepage1 = new Homepage();
        try {
            homepage1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage sta = (Stage)homepage.getScene().getWindow();
        sta.close();
    }
    /**
     *点击转跳到订单页面
     */
    @FXML
    void orderForm(ActionEvent event) {
        Stage stage = new Stage();
        OrderForm orderForm1 = new OrderForm();
        try {
            orderForm1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage sta = (Stage)orderForm.getScene().getWindow();
        sta.close();
    }
    /**
     *点击转跳到充值页面
     */
    @FXML
    void recharge(ActionEvent event) {
        Stage stage = new Stage();
        Recharge recharge1 = new Recharge();
        try {
            recharge1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage sta = (Stage)recharge.getScene().getWindow();
        sta.close();
    }
    @FXML
    void userSet(ActionEvent event) {
    }

    @FXML
    public String gettext1() {
        return text1.getText();
    }
    @FXML
    public String gettext2() {
        return text2.getText();
    }
    @FXML
    public String gettext3() {
        return text3.getText();
    }
    @FXML
    public String gettext4() {
        return text4.getText();
    }
    /**
     *获得确认充值按键的点击事件
     */
    @FXML
    void tc1(ActionEvent event) {
        /**
         *调用user在dao层的更新静态方法将用户名更新
         */
        UserDaoImp.user2.setUsername(gettext1());
        UserDaoImp.updateUser(UserDaoImp.user2);
    }
    @FXML
    void tc3(ActionEvent event) {
        /**
         *调用user在dao层的更新静态方法将用户密码更新
         */
        if(gettext2().equals(gettext3())){
            UserDaoImp.user2.setPassword(gettext3());
            UserDaoImp.updateUser(UserDaoImp.user2);
        }

    }
    @FXML
    void tc4(ActionEvent event) {
        /**
         *调用user在dao层的更新静态方法将手机号更新
         */
        UserDaoImp.user2.setPhoneNumber(gettext4());
        UserDaoImp.updateUser(UserDaoImp.user2);
    }

    /**
     *用户设置页面初始化
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
