package com.chenzheng.event.controller;


import com.chenzheng.event.service.ScenicSpotsService;
import com.chenzheng.event.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

/**
 *登录窗口控制器，实现登录窗口初始化，虽然登录没啥好初始化的
 */
public class LoginController implements Initializable {
    @FXML
    private Button register;
    @FXML
    private Button login;
    @FXML
    private Button visitorsLogin;
    @FXML
    private PasswordField passwor;
    @FXML
    private TextField usernam;
    /**
     *获得账号密码的函数，从textfield和passwordfield里面调取数据
     */
    @FXML
    public String getp() {
        return passwor.getText();
    }
    @FXML
    public String getu() {
        return usernam.getText();
    }
    /**
     *登录按键获得点击事件后调用user和景点的service层里的登录和加载方法，将数据库中登录的用户信息以及
     * 所有的景点信息加载入代码中
     */
    @FXML
    void login(ActionEvent event) {
        UserService userService = new UserService();
        ScenicSpotsService scenicSpotsService = new ScenicSpotsService();
        if (userService.login(getu(),getp())){
        scenicSpotsService.load();
            /**
             *关闭所在点窗口
             */
        Stage sta = (Stage)login.getScene().getWindow();
        sta.close();
            /**
             *如果登录成功调用主页类
             */
        Stage hstage = new Stage();
        Homepage homepage = new Homepage();
        try {
            homepage.start(hstage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            /**
             *登录失败调用登录失败页面
             */
            Stage stage = new Stage();
            Stage2 commonStage = new Stage2();
            try {
                commonStage.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @FXML
    /**
     *注册按键获得点击事件后调用user的service层里的注册方法
     */
    void register(ActionEvent event) {
        Stage stage = new Stage();
        Register register = new Register();
        try {
            register.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
