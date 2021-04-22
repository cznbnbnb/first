package com.chenzheng.event.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author cz
 * @date 2021/4/13
 */
public class Stage4 extends Application {
    /**
     *一个平平无奇的工具人页面，主要让你确认
     */
    @Override
    public void start(Stage cstage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/Stage4.fxml"));
        Scene scene1 = new Scene(root1);
        cstage.setScene(scene1);
        cstage.setTitle("去这儿旅行");
        cstage.show();
    }

}
