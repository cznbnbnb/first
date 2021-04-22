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

public class OrderForm extends Application {
    /**
     *订单页面的开始方法
     */
    @Override
    public void start(Stage ostage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/orderForm.fxml"));
        Scene scene1 = new Scene(root1);
        ostage.setScene(scene1);
        ostage.setTitle("去这儿旅行查单");
        ostage.show();
    }

}