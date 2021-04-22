package com.chenzheng.event.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import org.junit.Test;

import java.net.URL;

/**
 * @author cz
 * @date 2021/4/13
 */

public class Register extends Application {
    /**
     *注册窗口的开始方法
     */
    @Override
    public void start(Stage rstage) throws Exception {
        /**
         * 连接注册窗口的fxml文件
         */
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
        Scene scene1 = new Scene(root1);
        rstage.setScene(scene1);
        rstage.setTitle("去这儿旅行注册");
        rstage.show();
    }

}