package com.chenzheng.event.controller;

import com.chenzheng.event.dao.UserDaoImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author cz
 * @date 2021/4/13
 */
public class RechargeController implements Initializable {
    @FXML
    private ToggleButton orderForm;
    @FXML
    private Button confirm;
    @FXML
    private TextField number;
    @FXML
    private Label balance;
    @FXML
    private ToggleButton recharge;
    @FXML
    private ToggleButton userSet;
    @FXML
    private PasswordField cnumber;
    @FXML
    private Button tips;
    @FXML
    private ToggleButton homepage;
    public static String t1;
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
    @FXML
    void recharge(ActionEvent event) {

    }
    /**
     *点击转跳到设置页面
     */
    @FXML
    void userSet(ActionEvent event) {
        Stage stage = new Stage();
        UserSet userSet1 = new UserSet();
        try {
            userSet1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage sta = (Stage)userSet.getScene().getWindow();
        sta.close();
    }
    @FXML
    public String getcnumber() {
        return cnumber.getText();
    }
    @FXML
    public String getnumber() {
        return number.getText();
    }
    /**
     *点击确认充值
     */
    @FXML
    void confirm(ActionEvent event) {
        /**
         *   调用user的dao层中的静态属性，比对密码是否正确
         */
        if (getcnumber().equals(UserDaoImp.user2.getPassword()) ){
            UserDaoImp.user2.setIdealMoney(UserDaoImp.user2.getIdealMoney()+ Integer.parseInt(getnumber()));
            UserDaoImp.updateUser(UserDaoImp.user2);
            t1 = "充值成功！";
        }else{
            t1 = "密码错误，充值失败";
        }
        /**
         *打开提示界面，显示是否充值成功
         */
        Stage stage = new Stage();
        Stage4 stage4 = new Stage4();
        try {
            stage4.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *点击展示充值提示窗口并展示王霸条例
     */
    @FXML
    void tips(ActionEvent event) {
        Stage stage = new Stage();
        Tips tips1 = new Tips();
        try {
            tips1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
     *充钱才能变强，这里专门初始化出你剩多少钱来让你感受到你有多穷，来刺激消费
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        balance.setText(UserDaoImp.user2.getIdealMoney().toString());
    }
}
