package com.chenzheng.event.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author cz
 * @date 2021/4/18
 */

public class Search extends Application {
    /**
     *搜索界面，使用模糊查询显示景点信息；
     */
    @Override
    public void start(Stage sstage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/search.fxml"));
        Scene scene1 = new Scene(root1);
        sstage.setScene(scene1);
        sstage.setTitle("去这儿旅行搜索");
        sstage.show();
    }

}