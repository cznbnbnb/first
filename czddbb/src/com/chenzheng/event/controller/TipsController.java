package com.chenzheng.event.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author cz
 * @date 2021/4/17
 */
public class TipsController implements Initializable {
    @FXML
    private Button confirm;

    @FXML
    void confirm(ActionEvent event) {
        Stage sta = (Stage)confirm.getScene().getWindow();
        sta.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
