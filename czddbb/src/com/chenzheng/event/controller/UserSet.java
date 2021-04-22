package com.chenzheng.event.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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



public class UserSet extends Application {
    /**
     *用户设置页面的开始方法
     */
    @Override
    public void start(Stage ustage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/userSet.fxml"));
        Scene scene1 = new Scene(root1);
        ustage.setScene(scene1);
        ustage.setTitle("去这儿旅行设置");
        ustage.show();
    }

}