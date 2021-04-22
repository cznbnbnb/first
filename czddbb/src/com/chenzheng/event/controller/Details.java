package com.chenzheng.event.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author cz
 * @date 2021/4/19
 */

public class Details extends Application {
    private Stage dStage;
    /**
     *详情页面顾名思义，可以看到对应景点id的详细信息，这里是详情页面的开始方法
     */
    @Override
    public void start(Stage dStage) throws Exception {
        this.dStage = dStage;
        Parent root = FXMLLoader.load(getClass().getResource("../view/details.fxml"));
        Scene scene = new Scene(root);
        dStage.setScene(scene);
        dStage.setTitle("景点细节");
        dStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}