package com.chenzheng.event.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author cz
 * @date 2021/4/13
 */
public class Login extends Application {
    private Stage pStage;
    /**
     *打开登录窗口
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.pStage = primaryStage;
        /**
         *连接login.fxml文件
         */
        Parent root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("去这儿旅行");
        primaryStage.show();
    }

    /**
     * 主函数，一切的开始！
     */
    public static void main(String[] args) {
        launch(args);
    }

}
