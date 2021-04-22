package com.chenzheng.event.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author cz
 * @date 2021/4/17
 */

public class Tips extends Application {
    /**
     *一个平平无奇的工具人页面，主要为了展示王霸条例
     */
    @Override
    public void start(Stage tstage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/tips.fxml"));
        Scene scene1 = new Scene(root1);
        tstage.setScene(scene1);
        tstage.setTitle("去这儿旅行王霸条例");
        tstage.show();
    }

}
