package com.chenzheng.event.controller;

import com.chenzheng.event.bean.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author cz
 * @date 2021/4/13
 */
public class Homepage extends Application {

    private User user1;
    private Label label;
    public void gUser(User user){
        this.user1 = user;
    }
    /**
     *来了来了主页它来了，这里连接主页的fxml文件
     */
    @Override
    public void start(Stage hstage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/homepage.fxml"));
        Scene scene1 = new Scene(root1);
        hstage.setScene(scene1);
        hstage.setTitle("去这儿旅行主页");
        hstage.show();
    }
}
