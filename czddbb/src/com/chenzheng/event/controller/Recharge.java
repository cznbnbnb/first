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

public class Recharge extends Application {
    /**
     *欢迎来到氪金页面，这是它的开始方法
     */
    @Override
    public void start(Stage rstage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/Recharge.fxml"));
        Scene scene1 = new Scene(root1);
        rstage.setScene(scene1);
        rstage.setTitle("去这儿旅行充值");
        rstage.show();
    }

}
