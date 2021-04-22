package com.chenzheng.event.controller;

import com.chenzheng.event.bean.ScenicSpots;
import com.chenzheng.event.entity.Page;
import com.chenzheng.event.service.ScenicSpotsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

/**
 * @author cz
 * @date 2021/4/18
 */
public class SearchController implements Initializable {
    @FXML
    private Button next;
    @FXML
    private HBox t4;
    @FXML
    private HBox t5;
    @FXML
    private Button back;
    @FXML
    private Button check;
    @FXML
    private Label number;
    @FXML
    private TextArea text3;
    @FXML
    private TextArea text4;
    @FXML
    private TextArea text1;
    @FXML
    private Button sorting;
    @FXML
    private TextArea text2;
    @FXML
    private Button searchAgain;
    @FXML
    private TextArea text5;
    @FXML
    private HBox t1;
    @FXML
    private TextField idText;
    @FXML
    private HBox t2;
    @FXML
    private HBox t3;
    Page page1 = new Page();
    /**
     *点击展示下一页
     */
    @FXML
    void next(ActionEvent event) {
        if (text5.getText() != null){
            page1.setCurrentPage(page1.getCurrentPage()+1);
            page1.setData();
            Stage stage = new Stage();
            Search search1 = new Search();
            text1.setText(null);
            text2.setText(null);
            text3.setText(null);
            text4.setText(null);
            text5.setText(null);
            for (int i = 0; i < page1.getData().size(); i++) {
                switch (i+1){
                    case 1 : text1.setText(page1.getData().get(0).getAll());break;
                    case 2 : text2.setText(page1.getData().get(1).getAll());break;
                    case 3 : text3.setText(page1.getData().get(2).getAll());break;
                    case 4 : text4.setText(page1.getData().get(3).getAll());break;
                    case 5 : text5.setText(page1.getData().get(4).getAll());break;
                    default:
                        System.out.println("false");
                }
            }

            text1.setWrapText(true);
            text2.setWrapText(true);
            text3.setWrapText(true);
            text4.setWrapText(true);
            text5.setWrapText(true);

            text1.setEditable(false);
            text2.setEditable(false);
            text3.setEditable(false);
            text4.setEditable(false);
            text5.setEditable(false);
        }


    }
    /**
     *点击回到上一页
     */
    @FXML
    void back(ActionEvent event) {
        if (page1.getCurrentPage() > 1){
            page1.setCurrentPage(page1.getCurrentPage()-1);
            page1.setData();
            Stage stage = new Stage();
            Search search1 = new Search();
            text1.setText(null);
            text2.setText(null);
            text3.setText(null);
            text4.setText(null);
            text5.setText(null);
            for (int i = 0; i < page1.getData().size(); i++) {
                switch (i+1){
                    case 1 : text1.setText(page1.getData().get(0).getAll());break;
                    case 2 : text2.setText(page1.getData().get(1).getAll());break;
                    case 3 : text3.setText(page1.getData().get(2).getAll());break;
                    case 4 : text4.setText(page1.getData().get(3).getAll());break;
                    case 5 : text5.setText(page1.getData().get(4).getAll());break;
                    default:
                        System.out.println("false");
                }
            }

            text1.setWrapText(true);
            text2.setWrapText(true);
            text3.setWrapText(true);
            text4.setWrapText(true);
            text5.setWrapText(true);

            text1.setEditable(false);
            text2.setEditable(false);
            text3.setEditable(false);
            text4.setEditable(false);
            text5.setEditable(false);

        }

    }
    @FXML
    void sorting(ActionEvent event) {
    }
    @FXML
    void idText(ActionEvent event) {
    }
    @FXML
    void check(ActionEvent event) {
    }
    @FXML
    void searchAgain(ActionEvent event) {
    }
    /**
     *初始化查询结果，以分页的方式展示信息
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        page1.setSearchText(HomepageController.searchText1);
        page1.setCurrentPage(1);
        page1.setData();
        for (int i = 0; i < page1.getData().size(); i++) {
            switch (i+1){
                case 1 : text1.setText(page1.getData().get(0).getAll());break;
                case 2 : text2.setText(page1.getData().get(1).getAll());break;
                case 3 : text3.setText(page1.getData().get(2).getAll());break;
                case 4 : text4.setText(page1.getData().get(3).getAll());break;
                case 5 : text5.setText(page1.getData().get(4).getAll());break;
                default:
                    System.out.println("pageFalse");
            }
        }

        text1.setWrapText(true);
        text2.setWrapText(true);
        text3.setWrapText(true);
        text4.setWrapText(true);
        text5.setWrapText(true);

        text1.setEditable(false);
        text2.setEditable(false);
        text3.setEditable(false);
        text4.setEditable(false);
        text5.setEditable(false);


    }

}
