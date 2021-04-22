package com.chenzheng.event.controller;

import com.chenzheng.event.dao.UserDaoImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author cz
 * @date 2021/4/13
 */
public class Stage3Controller implements Initializable {

    @FXML
    private Button confirm;

    @FXML
    private Label label1;


    @FXML
    void confirm(ActionEvent event) {
        Stage sta = (Stage)confirm.getScene().getWindow();
        sta.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label1.setText(UserDaoImp.user2.getIdealMoney().toString());
    }





}
